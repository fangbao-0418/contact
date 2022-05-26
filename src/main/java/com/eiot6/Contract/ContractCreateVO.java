package com.eiot6.Contract;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
 
// @Data
@ApiModel("创建Swagger响应结果")
public class ContractCreateVO {
 
    @ApiModelProperty("id")
    public Integer id;

    @ApiModelProperty(name = "姓名 len:32", required = true)
    @Column(length = 20, nullable = false)
    public String name;
 
    @ApiModelProperty(name = "电话 len:32", required = true)
    @Column(length = 32, nullable = false)
    public String telephone;
    
    @ApiModelProperty(name = "公司 len:100", required = true)
    @Column(length = 100, nullable = false)
    public String company;

    @ApiModelProperty(name = "建筑类型 len:200", required = true)
    @Column(length = 200, nullable = false)
    public String building_type;

    @ApiModelProperty(name = "需求描述 len:250", required = true)
    @Column(length = 250, nullable = false)
    public String description;
}