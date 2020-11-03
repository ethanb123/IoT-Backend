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
    private String ip;

//added mac address to the device itself
    public Device(Long id, String name, String macAddress, String ip) {
        this.id = id;
        this.name = name;
        //sets macAddress
        this.macAddress = macAddress;
        //set ip address
        this.ip = ip;
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

    //get and set functions for the ip address variable inside device
    public String getIp() {return ip;}

    public void setIp(String ip) {this.ip = ip;}

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + ", MAC Address = " + macAddress + ", IP Address = " + ip + '\'' +
                '}';
    }
}
