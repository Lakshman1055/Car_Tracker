package com.lakshman.Service;

import com.lakshman.Entity.Reading;
import com.lakshman.Entity.Vehicle;
import com.lakshman.Repository.ReadingRepository;
import com.lakshman.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    @Transactional
    public void create(Reading reading) {

        String vin = reading.getVin();
        Reading existingReading = readingRepository.findOne(vin);
        if(existingReading==null){
            readingRepository.create(reading);
        }else{
            readingRepository.update(reading,existingReading);
        }

    }
}
