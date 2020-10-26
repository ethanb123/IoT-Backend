package com.myproject.iot.controller;

import com.myproject.iot.domain.Device;
import com.myproject.iot.dto.CreateDevicePayload;
import com.myproject.iot.dto.DeviceDto;
import com.myproject.iot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/devices")
public class Controller {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/")
    public ResponseEntity<Device> addDevice(@RequestBody CreateDevicePayload payload) {
        return new ResponseEntity<>(deviceService.addDevice(payload.getName()), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public List<DeviceDto> getDevices() {
        return deviceService.getDevices()
                .stream()
                .map(device -> new DeviceDto(device.getId(), device.getName()))
                .collect(Collectors.toList());
    }

    // Added an attempt at a delete mapping function
    // deleteDevice can be found in the deviceService class
    @DeleteMapping("/2")
    public String deleteDevice(@PathVariable Long id) { //passes through a long id to use to find device
        return deviceService.deleteDevice(id); //passes through the id, returns a string after device is deleted
    }


    // Exercise: add the code delete a device and test it, see DeviceRepository class
}
