package com.eiot6.Project.impl;

import java.util.Map;
import java.util.Optional;

import javax.swing.tree.RowMapper;
import com.eiot6.Project.ProjectEntity;
import com.eiot6.Project.ProjectRepository;
import com.eiot6.Project.ProjectService;
import com.eiot6.Project.dto.ProjectCreateVO;
import com.eiot6.Project.dto.TextVO;
import com.eiot6.Utils.JpaUtil;
import com.eiot6.Utils.Result;
import com.eiot6.Utils.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
  
  @Autowired
  public ProjectRepository projectRegistory;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public Result<Boolean> createProject(ProjectCreateVO body) throws DataAccessException {
    ProjectEntity project = new ProjectEntity();
    JpaUtil.copyNotNullProperties(body, project);
    projectRegistory.save(project);

    String sql = "CREATE TABLE " + body.identifier + "("
    + "id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',"
    + "`code` varchar(32) NOT NULL DEFAULT '' COMMENT 'code',"
    + "`text` varchar(255) NOT NULL DEFAULT '' COMMENT '文本',"
    + "`lang` varchar(100) NOT NULL DEFAULT '' COMMENT '语言',"
    + "`gmt_create` BIGINT(13) NOT NULL COMMENT '创建日期',"
    + "`gmt_modify` BIGINT(13) NOT NULL COMMENT '修改日期'"
    + ") DEFAULT CHARSET utf8mb4";
    jdbcTemplate.execute(sql);

    return ResultUtil.success(true);
  }

  @Override
  public Result<ProjectCreateVO> editProject(ProjectCreateVO body) {
    ProjectEntity project = new ProjectEntity();
    JpaUtil.copyNotNullProperties(body, project);
    if (body.id != null) {
      Optional<ProjectEntity> originalProject = projectRegistory.findById(body.id);
      if (originalProject.isPresent()) {
        JpaUtil.copyNotNullProperties(originalProject.get(), project);
      }
    }
    JpaUtil.copyNotNullProperties(body, project);
    projectRegistory.save(project);
    JpaUtil.copyNotNullProperties(project, body);
    return ResultUtil.success(body);
  }
  
  @Override
  public Result<TextVO> addText(TextVO body) {
    Optional<ProjectEntity> originalProject = projectRegistory.findById(body.projectId);
    String table = originalProject.get().getIdentifier();
    Long t = (long) 0;
    String sql = "INSERT INTO " + table
    + " (code, text, lang, gmt_create, gmt_modify) VALUES"
    + " ('" + body.code + "', '" + body.text + "', '"+ body.lang + "', " + t + ", "+ t + ")";
    jdbcTemplate.execute(sql);
    return ResultUtil.success(body);
  }

  @Override
  public Result<TextVO> editText(TextVO body) {
    Optional<ProjectEntity> originalProject = projectRegistory.findById(body.projectId);
    String table = originalProject.get().getIdentifier();
    String sql = "SELECT id, code, text, lang, gmt_create, gmt_modify FROM " + table + " WHERE id = " + body.id;

    TextVO res = jdbcTemplate.queryForObject(sql, new TextVO());
    res.setProjectId(body.projectId);

    JpaUtil.copyNotNullProperties(res, body);

    Long t = System.currentTimeMillis();
    body.setGmt_modify(t);
    String sql2 = "UPDATE " + table
    + " SET code = '" + body.code
    + "', text = '" + body.text
    + "', lang = '" + body.lang
    + "', gmt_create = " + res.gmt_create
    + ", gmt_modify = " + t
    + " WHERE id = " + body.id;
    jdbcTemplate.execute(sql2);
    return ResultUtil.success(body);

  }
}
