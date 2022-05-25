package com.eiot6.Contract;

import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import com.eiot6.Utils.Result;
import com.eiot6.Utils.ResultUtil;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

@RestController
@Api(tags = {"官网"}, description = "官网")
// @SpringBootApplication
public class ContractApplication {
  @Autowired
  private ContractRepository contractRepository;

  @ApiOperation(value = "新增联系信息")
	@PostMapping(path="/api/submit/contract")
  Result submitContract(@RequestBody ContractCreateVO body) {
    Contract data = new Contract();
    data.setName(body.name);
    data.setcompany(body.company);
    data.setBuildingType(body.building_type);
    data.setTelephone(body.telephone);
    data.setDescription(body.description);  
    Contract s = contractRepository.save(data);
    // Object res = new Object();
    // res.a = "ok";
    return ResultUtil.success(true);
  }
}
