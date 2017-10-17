package com.lakshman.Controller;

import com.lakshman.Entity.Vehicle;
import com.lakshman.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VechileController {

    @Autowired
    VehicleService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces={"application/xml", "application/json"})
    public List<Vehicle> findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void create(@RequestBody Vehicle vehicle){
        service.create(vehicle);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void update(@RequestBody Vehicle[] vehicles){
        service.update(vehicles);
    }

}
