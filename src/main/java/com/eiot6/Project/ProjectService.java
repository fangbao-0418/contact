package com.eiot6.Project;

import java.io.FilterOutputStream;

import javax.servlet.http.HttpServletResponse;

import com.eiot6.Project.dto.ProjectCreateVO;
import com.eiot6.Project.dto.TextVO;
import com.eiot6.Utils.Result;

public interface ProjectService {
  public Result<Iterable<ProjectEntity>> listProject();

  public FilterOutputStream exportProject(HttpServletResponse response);

  public Result<Boolean> createProject(ProjectCreateVO body);

  public Result<ProjectCreateVO> editProject(ProjectCreateVO body);

  public Result<TextVO> addText(TextVO body);

  public Result<TextVO> editText(TextVO body);
}
