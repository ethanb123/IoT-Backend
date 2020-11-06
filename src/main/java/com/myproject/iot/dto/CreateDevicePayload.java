package com.myproject.iot.dto;

public class CreateDevicePayload {

    private String name;
    //mac address for the payload
    private String macAddress;
    //ip address for the payload
    private String ip;
    //gateway impamentation
    private boolean isGateway;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //added get and set for mac address
    public String getMacAddress() {return macAddress;}

    public void setMacAddress (String macAddress) {this.macAddress = name;}

    //added get and set for ip address
    public String getIp() {return ip;}

    public void setIp(String ip) {this.ip = ip;}

    //added get and set for gateway check
    public boolean setGateway() { return isGateway;}

    public boolean getGateway() {this.isGateway = isGateway; return isGateway;}






}
