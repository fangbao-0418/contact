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
public class TextVO {
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

  // @Override
  // public TextVO mapRow(ResultSet rs, int rowNum) throws SQLException {
  //   TextVO res = new TextVO();
  //   JpaUtil.copyNotNullProperties(rs, res);
  //   return res;
  // }
}
