package com.lakshman.Service;

import com.lakshman.Entity.Vehicle;
import com.lakshman.Repository.VehicleRepository;
import com.lakshman.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void create(Vehicle vehicle) {
        repository.create(vehicle);
    }

    @Transactional
    public void update(Vehicle[] vehicles) {

        for (Vehicle v: vehicles) {
            Vehicle vec = repository.findVec(v.getVin());
            if(vec!=null){
                repository.update(v,vec);
            }else{
                repository.create(v);
            }
        }
    }
}
