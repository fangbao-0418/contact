package com.eiot6.Contact;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
 
// @Data
@ApiModel("创建Swagger响应结果")
public class ContactCreateVO {
 
    @ApiModelProperty("id")
    public Integer id;

    @ApiModelProperty(name = "姓名 len:32", required = true)
    public String name;
 
    @ApiModelProperty(name = "电话 len:32", required = true)
    public String telephone;
    
    @ApiModelProperty(name = "公司 len:100", required = true)
    public String company;

    @ApiModelProperty(name = "建筑类型 len:200", required = true)
    public String building_type;

    @ApiModelProperty(name = "需求描述 len:250", required = true)
    public String description;
}