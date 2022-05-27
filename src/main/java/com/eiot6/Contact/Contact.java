package com.eiot6.Contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Column(length = 20, nullable = false)
    private String name;
    
    @Column(length = 32, nullable = false)
    private String telephone;

    @Column(length = 100, nullable = false)
    private String company;
    
    @Column(length = 200, nullable = false)
    private String building_type;
    
    @Column(length = 250, nullable = false)
    private String description;

    @Column(length = 13, nullable = false)
    private long gmt_create;

    @Column(length = 20, nullable = false)
    private String ip = "";

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setcompany(String company) {
        this.company = company;
    }

    public void setBuildingType(String building_type) {
        this.building_type = building_type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setCreateTime(long t) {
        this.gmt_create = t;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}