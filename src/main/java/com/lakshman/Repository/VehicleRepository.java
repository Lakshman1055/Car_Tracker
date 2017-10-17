package com.lakshman.Repository;

import com.lakshman.Entity.Vehicle;

import java.util.List;

public interface VehicleRepository {

    List<Vehicle> findAll();
    void create(Vehicle vehicle);
    void update(Vehicle vehicle,Vehicle oldVec);
    Vehicle findVec(String id);
}
