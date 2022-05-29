package com.eiot6.Project;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

public interface ProjectRepository extends CrudRepository<ProjectEntity, Integer> {
  @Query("select count(*) from Contact c where c.ip = :ip")
  int getIpCount(@Param("ip") String ip);
}
