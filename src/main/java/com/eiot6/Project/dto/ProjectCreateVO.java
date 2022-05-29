package com.eiot6.Project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("项目创建")
@Data
public class ProjectCreateVO {
  @ApiModelProperty("项目ID")
  public Integer id;

  @ApiModelProperty("项目名称")
  public String name;

  @ApiModelProperty("项目标识符")
  public String identifier;

  @ApiModelProperty("项目描述")
  public String description;

  @ApiModelProperty("维护人")
  public String maintainer;
}
