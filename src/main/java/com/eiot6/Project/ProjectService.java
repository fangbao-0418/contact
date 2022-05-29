package com.eiot6.Project;

import com.eiot6.Project.dto.ProjectCreateVO;
import com.eiot6.Project.dto.TextVO;
import com.eiot6.Utils.Result;

public interface ProjectService {
  public Result<Boolean> createProject(ProjectCreateVO body);

  public Result<ProjectCreateVO> editProject(ProjectCreateVO body);

  public Result<TextVO> addText(TextVO body);

  public Result<TextVO> editText(TextVO body);
}
