package com.myproject.iot.dto;

public class DeviceDto {

    private long id;
    private String name;
    private String macAddress;

    public DeviceDto() {
    }
//added string mac address to the parameters of the deviceDTO function
    public DeviceDto(long id, String name, String macAddress) {
        this.id = id;
        this.name = name;
        this.macAddress = macAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //added get and set functions for the mac address
    public String getMacAddress() {return macAddress;}

    public void setMacAddress(String macAddress) {this.macAddress = macAddress;}
}
