package com.myproject.iot.service;

import com.myproject.iot.domain.Device;
import com.myproject.iot.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    //added parameter for mac address
    public Device addDevice(String name, String macAddress, String ip, boolean isGateway, String deviceType, int cpID) {
        Device device = new Device();
        device.setName(name);
        //set the mac address when creating device
        device.setMacAddress(macAddress);
        //set the ip address when creating device
        device.setIp(ip);
        //set the gateway status
        device.setGateway(isGateway);
        //set the deviceType status
        device.setDeviceType(deviceType);
        //set the child or parent id
        device.setCpID(cpID);

        return deviceRepository.save(device);
    }


    //First attempt at a delete function
    //called in the controller class
    public void deleteDevice(Long id) {
        //find and delete the device by the id passed through
       deviceRepository.deleteById(id);
    }

    //function to check to see if it is deleted
    public boolean deviceExists(long id) {
        return deviceRepository.existsById(id);
    }

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }
}
