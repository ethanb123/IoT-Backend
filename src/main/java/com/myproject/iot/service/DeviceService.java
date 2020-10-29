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
    public void deleteDevice(Long id) {
        //find and delete the device by the id passed through
       deviceRepository.deleteById(id);
    }

    //checks to see if it is deleted
    public boolean deviceExists(long id) {
        return deviceRepository.existsById(id);
    }

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }
}
