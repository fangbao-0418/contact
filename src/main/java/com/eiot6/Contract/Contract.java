package com.eiot6.Contract;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String telephone;

    private String company;

    private String building_type;

    private String description;

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
}