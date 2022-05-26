package com.eiot6.Contract;

import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import com.eiot6.Utils.Result;
import com.eiot6.Utils.ResultUtil;
import javax.servlet.http.HttpServletRequest;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@Api(tags = {"官网"}, description = "官网")
// @SpringBootApplication
public class ContractApplication {
  @Autowired
  private ContractRepository contractRepository;

  @ApiOperation(value = "新增联系信息")
	@PostMapping(path="/api/submit/contract")
  Result<Boolean> submitContract(@RequestBody ContractCreateVO body) {
    Contract data = new Contract();
    data.setName(body.name);
    data.setcompany(body.company);
    data.setBuildingType(body.building_type);
    data.setTelephone(body.telephone);
    data.setDescription(body.description);  
    contractRepository.save(data);
    return ResultUtil.success(true);
  }

  @GetMapping(path="/api/get/ip")
	public String getIp(HttpServletRequest request) throws UnknownHostException {
		// String ipAddress = request.getHeader("x-forwarded-for");
		String ipAddress = request.getHeader("WL-Proxy-Client-IP");
		String ipAddress2 = request.getHeader("Proxy-Client-IP");
		String ipAddress3 = request.getHeader("x-forwarded-for");
		String ipAddress4 = request.getRemoteAddr();
		InetAddress inet = null;
		inet = InetAddress.getLocalHost();
		String ipAddress5 = inet.getHostAddress();
		return ipAddress + ipAddress5 + ipAddress2 + ipAddress3 + ipAddress4;
	}
}
