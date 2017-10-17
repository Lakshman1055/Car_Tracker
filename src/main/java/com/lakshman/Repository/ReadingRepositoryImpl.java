package com.lakshman.Repository;

import com.lakshman.Entity.Reading;
import com.lakshman.Entity.Tires;
import com.lakshman.Entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReadingRepositoryImpl implements  ReadingRepository {

    @PersistenceContext
    EntityManager em;

    public Reading findOne(String vin) {
        return em.find(Reading.class, vin);
    }

    public void create(Reading reading) {
        Tires tires = reading.getTires();
        em.persist(tires);
        em.persist(reading);
    }

    public void update(Reading newReading, Reading existingReading) {

        existingReading.setTires(newReading.getTires());
        existingReading.setLatitude(newReading.getLatitude());
        existingReading.setLongitude(newReading.getLongitude());
        existingReading.setTimestamp(newReading.getTimestamp());
        existingReading.setFuelVolume(newReading.getFuelVolume());
        existingReading.setSpeed(newReading.getSpeed());
        existingReading.setEngineHp(newReading.getEngineHp());
        existingReading.setCheckEngineLightOn(newReading.isCheckEngineLightOn());
        existingReading.setEngineCoolantLow(newReading.isEngineCoolantLow());
        existingReading.setCruiseControlOn(newReading.isCruiseControlOn());
        existingReading.setEngineRpm(newReading.getEngineRpm());
        em.merge(existingReading);

    }
}
