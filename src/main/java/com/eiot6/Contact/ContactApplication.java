package com.eiot6.Contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

import com.eiot6.Utils.Result;
import com.eiot6.Utils.ResultUtil;
import com.eiot6.Utils.JpaUtil;

@RestController
@Api(tags = {"官网"}, description = "官网")
public class ContactApplication {
  @Autowired
  private ContactRepository contactRepository;
  
  private Logger logger = LoggerFactory.getLogger(ContactApplication.class);

  @ApiOperation(value = "修改联系信息")
	@PostMapping(path="/api/edit/contact")
  Result<Contact> updateContract(@RequestBody ContactCreateVO body) {
    Contact data = new Contact();
    if(body.id != null) {
      Optional<Contact> originalUser = contactRepository.findById(body.id);
      if (originalUser.isPresent()) {
        JpaUtil.copyNotNullProperties(originalUser.get(), data);
      }
    }
    JpaUtil.copyNotNullProperties(body, data);
    contactRepository.save(data);
    return ResultUtil.success(data);
  }

  @ApiOperation(value = "获取联系信息")
	@GetMapping(path="/api/get/contact")
  Result<java.util.Optional<Contact>> getContract(@RequestParam Integer id) {
    java.util.Optional<Contact> data = contactRepository.findById(id);
    return ResultUtil.success(data);
  }

  @ApiOperation(value = "新增联系信息")
	@PostMapping(path="/api/submit/contact")
  Result<Contact > submitContract(HttpServletRequest request, @RequestBody ContactCreateVO body) {
    long t = System.currentTimeMillis();
    String ip = request.getHeader("x-forwarded-for");
    Contact data = new Contact();
    
    int num = contactRepository.getIpCount(ip);
    if (num > 50) {
      logger.info("{} {} {} {} {}", body.name, body.telephone, body.company, body.building_type, body.description);
      // return ResultUtil.error(10000, "当前ip提交数据已超限");
      return  ResultUtil.success(data);
    }

    data.setName(body.name);
    data.setCompany(body.company);
    data.setBuilding_type(body.building_type);
    data.setTelephone(body.telephone);
    data.setDescription(body.description);
    data.setGmt_create(t);
    if (ip != null) {
      data.setIp(ip);
    }
    contactRepository.save(data);
    return ResultUtil.success(data);
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
