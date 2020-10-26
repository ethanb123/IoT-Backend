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

    public Device addDevice(String name) {
        Device device = new Device();
        device.setName(name);
        return deviceRepository.save(device);
    }


    //First attempt at a delete function
    //called in the controller class
    public String deleteDevice(long id) {
        // delete function that passes through the device id to the delete function to find in the repository
        Device temp = deviceRepository.getOne(id);
        //delete the device after it is found
        deviceRepository.delete(temp);
        //return a string to say deleted
        return "Deleted";
    }

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }
}
