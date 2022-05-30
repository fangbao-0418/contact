package com.eiot6.Project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import lombok.*; 

@Data
@Entity
@Table(name="project")
public class ProjectEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  @Column(length = 20, nullable = false)
  private String name = "";
  
  @Column(length = 6, nullable = false)
  private String identifier = "";

  @Column(length = 250, nullable = false)
  private String description = "";

  @Column(length = 30, nullable = false)
  private String maintainer = "";
}
