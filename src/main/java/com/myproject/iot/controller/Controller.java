package com.myproject.iot.controller;

import com.myproject.iot.domain.Device;
import com.myproject.iot.dto.CreateDevicePayload;
import com.myproject.iot.dto.DeviceDto;
import com.myproject.iot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/devices")
public class Controller {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/")
    public ResponseEntity<Device> addDevice(@RequestBody CreateDevicePayload payload) {
        //added payload.getMacAddress() to parameters needed to generate a new device
        return new ResponseEntity<>(deviceService.addDevice(payload.getName(), payload.getMacAddress(), payload.getIp(), payload.getGateway(), payload.getDeviceType(), payload.getCpID()), HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public List<DeviceDto> getDevices() {
        return deviceService.getDevices()
                .stream()
                //added mac address to the function call to pass through to the device creation
                .map(device -> new DeviceDto(device.getId(), device.getName(), device.getMacAddress(), device.getIp(), device.getGateway(), device.getDeviceType(), device.getCpID()))
                .collect(Collectors.toList());
    }

    // Added an attempt at a delete mapping function
    // deleteDevice can be found in the deviceService class
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable Long id) { //passes through a long id to use to find device
        //passes through the id to the delete function in deviceService
        deviceService.deleteDevice(id);
        //test if it is actually deleted
        boolean a = deviceService.deviceExists(id);
        String msg = "";
        if (a)
            msg = "Error";
        if (!a)
            msg = "Deleted";
        //returning set message
        return new ResponseEntity<>(msg, HttpStatus.OK);
        }

    @DeleteMapping("/deleteGateway/{id}")
    public ResponseEntity<String> deleteGateway(@PathVariable Long id) {
        deviceService.deleteGateway(id);
        String msg = "Gateway deleted";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    //first attempt at editing existing device
    // had to add and 'id' get and set section in payload, as it was just auto generated in the device.java class
    // before. not sure if it will grab the correct id yet, needs testing
    @PutMapping("/edit")
    public ResponseEntity<Device> editDevice(@RequestBody CreateDevicePayload payload) {
        Device device = deviceService.getDevice(payload.getId());
        device.setName(payload.getName());
        device.setMacAddress(payload.getMacAddress());
        device.setIp(payload.getIp());
        return ResponseEntity.ok(deviceService.save(device));
    }



}
