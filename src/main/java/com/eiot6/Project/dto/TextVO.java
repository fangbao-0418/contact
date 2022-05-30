package com.eiot6.Project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.eiot6.Utils.JpaUtil;
import org.springframework.jdbc.core.RowMapper;

@ApiModel("创建文本")
@Data
public class TextVO implements RowMapper<TextVO> {
  @ApiModelProperty("ID")
  public Integer id;

  @ApiModelProperty("项目ID")
  public Integer projectId;

  @ApiModelProperty("code")
  public String code;

  @ApiModelProperty("文本")
  public String text;

  @ApiModelProperty("语言")
  public String lang;

  @ApiModelProperty("创建时间")
  public long gmt_create;

  @ApiModelProperty("修改时间")
  public long gmt_modify;

  @Override
  public TextVO mapRow(ResultSet rs, int rowNum) throws SQLException {
    TextVO res = new TextVO();
    res.setCode(rs.getString("code"));
    res.setId(rs.getInt("id"));
    res.setLang(rs.getString("lang"));
    res.setText(rs.getString("text"));
    res.setGmt_create(rs.getLong("gmt_create"));
    res.setGmt_modify(rs.getLong("gmt_modify"));
    return res;
  }
}
