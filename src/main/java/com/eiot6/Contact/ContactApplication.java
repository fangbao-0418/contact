package com.eiot6.Contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import com.eiot6.Utils.Result;
import com.eiot6.Utils.ResultUtil;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@Api(tags = {"官网"}, description = "官网")
public class ContactApplication {
  @Autowired
  private ContactRepository contactRepository;
  
  private Logger logger = LoggerFactory.getLogger(ContactApplication.class);

  @ApiOperation(value = "新增联系信息")
	@PostMapping(path="/api/submit/contact")
  Result<Boolean> submitContract(HttpServletRequest request, @RequestBody ContactCreateVO body) {
    long t = System.currentTimeMillis();
    String ip = request.getHeader("x-forwarded-for");
    Contact data = new Contact();
    
    int num = contactRepository.getIpCount(ip);
    if (num > 50) {
      logger.info("{} {} {} {} {}", body.name, body.telephone, body.company, body.building_type, body.description);
      // return ResultUtil.error(10000, "当前ip提交数据已超限");
      return  ResultUtil.success(true);
    }

    data.setName(body.name);
    data.setcompany(body.company);
    data.setBuildingType(body.building_type);
    data.setTelephone(body.telephone);
    data.setDescription(body.description);
    data.setCreateTime(t);

    if (ip != null) {
      data.setIp(ip);
    }
    contactRepository.save(data);
    return ResultUtil.success(true);
  }

  @GetMapping(path="/api/get/ip")
	public String getIp(HttpServletRequest request) throws UnknownHostException {
    InetAddress inet = null;
		inet = InetAddress.getLocalHost();
		String ipAddress = request.getHeader("WL-Proxy-Client-IP");
		String ipAddress2 = request.getHeader("Proxy-Client-IP");
		String ipAddress3 = request.getHeader("x-forwarded-for");
		String ipAddress4 = request.getRemoteAddr();
		String ipAddress5 = inet.getHostAddress();
		return ipAddress + ipAddress2 + ipAddress3 + ipAddress4 + ipAddress5;
	}
}
