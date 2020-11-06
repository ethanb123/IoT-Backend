package com.myproject.iot.dto;

public class DeviceDto {

    private long id;
    private String name;
    private String macAddress;
    private String ip;
    private boolean isGateway;

    public DeviceDto() {
    }
//added string mac address to the parameters of the deviceDTO function
    // added string ip to the parameters of the device DTO function
    public DeviceDto(long id, String name, String macAddress, String ip, boolean isGateway) {
        this.id = id;
        this.name = name;
        this.macAddress = macAddress;
        this.ip = ip;
        this.isGateway = isGateway;
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

    //added get and set function for the ip address
    public String getIp() {return ip;}

    public void setIp(String ip) {this.ip = ip;}
}
