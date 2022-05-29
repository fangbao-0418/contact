package com.eiot6.Project;

import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import javax.annotation.Resource;

import com.eiot6.Project.dto.ProjectCreateVO;
import com.eiot6.Project.dto.TextVO;
import com.eiot6.Utils.Result;

@RestController
@Api(tags = {"国际化项目"}, description = "国际化项目管理")
public class ProjectController {

  @Resource
  public ProjectService projectService;

  @PostMapping("/create/project")
  Result<Boolean> createPoject (@RequestBody ProjectCreateVO body) {
    return projectService.createProject(body);
  }

  @PostMapping("/edit/project")
  Result<ProjectCreateVO> editPoject (@RequestBody ProjectCreateVO body) {
    return projectService.editProject(body);
  }

  @PostMapping("/create/text")
  Result<TextVO> addText (@RequestBody TextVO body) {
    return projectService.addText(body);
  }

  @PostMapping("/edit/text")
  Result<TextVO> editText (@RequestBody TextVO body) {
    return projectService.editText(body);
  }
}
