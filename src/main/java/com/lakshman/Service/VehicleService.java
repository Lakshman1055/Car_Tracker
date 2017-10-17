package com.lakshman.Service;

import com.lakshman.Entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();
    void create(Vehicle vehicle);
    void update(Vehicle[] vehicle);
}
