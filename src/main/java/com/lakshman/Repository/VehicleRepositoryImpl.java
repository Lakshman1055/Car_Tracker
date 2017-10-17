package com.lakshman.Repository;

import com.lakshman.Entity.Vehicle;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    EntityManager em;

    public List<Vehicle> findAll() {
        //TypedQuery<Vehicle> q = (TypedQuery<Vehicle>) em.createNativeQuery("CALL getAllVehicles()");
        //TypedQuery<Vehicle> query = em.createQuery("select vec from Vehicle vec",Vehicle.class);
        StoredProcedureQuery qu = em.createNamedStoredProcedureQuery("getAll");
        List<Vehicle> vehicleList = qu.getResultList();
        return vehicleList;

    }

    public Vehicle findVec(String vin) {
        return em.find(Vehicle.class,vin);
    }

    public void create(Vehicle vehicle) {
        em.persist(vehicle);
    }

    public void update(Vehicle vehicle, Vehicle oldVec) {
        oldVec.setVin(vehicle.getVin());
        oldVec.setMake(vehicle.getMake());
        oldVec.setModel(vehicle.getModel());
        oldVec.setYear(vehicle.getYear());
        oldVec.setRedLineRpm(vehicle.getRedLineRpm());
        oldVec.setMaxFuelVolume(vehicle.getMaxFuelVolume());
        oldVec.setLastServiceDate(vehicle.getLastServiceDate());
        em.merge(oldVec);
    }
}
