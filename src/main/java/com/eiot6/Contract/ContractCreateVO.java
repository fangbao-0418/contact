package com.eiot6.Contract;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
// import lombok.Data;
 
// @Data
@ApiModel("创建Swagger响应结果")
public class ContractCreateVO {
 
    @ApiModelProperty("id")
    public Integer id;
 
    @ApiModelProperty("姓名 len:32")
    public String name;
 
    @ApiModelProperty("电话 len:32")
    public String telephone;
 
    @ApiModelProperty("公司 len:100")
    public String company;

    @ApiModelProperty("建筑类型 len:200")
    public String building_type;

    @ApiModelProperty("需求描述 len:250")
    public String description;
}