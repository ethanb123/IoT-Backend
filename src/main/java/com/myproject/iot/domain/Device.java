package com.myproject.iot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String macAddress;

//added mac address to the device itself
    public Device(Long id, String name, String macAddress) {
        this.id = id;
        this.name = name;
        //sets macAddress
        this.macAddress = macAddress;
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

    //get and set functions for the mac address variable inside device
    public String getMacAddress() {return macAddress;}

    public void setMacAddress(String macAddress) {this.macAddress = macAddress;}

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + ", MAC Address = " + macAddress + '\'' +
                '}';
    }
}
