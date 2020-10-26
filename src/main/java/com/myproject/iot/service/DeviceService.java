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
        //temporary string to check if device was deleted successfully
        String returnStr ="";
        //find and delete the device by the id passed through
       deviceRepository.deleteById(id);
       boolean a = deviceRepository.existsById(id);
       if (a)
           returnStr = "Error";
       if (!a)
           returnStr = "Deleted";

       return returnStr;
    }

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }
}
