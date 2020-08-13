package com.myproject.iot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Device {

    @Id
    private Long id;
    private String name;


    public Device(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Device() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
