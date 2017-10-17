package com.lakshman.Repository;

import com.lakshman.Entity.Reading;
import com.lakshman.Entity.Vehicle;
import com.sun.org.apache.regexp.internal.RE;

public interface ReadingRepository {

    Reading findOne(String vin);
    void create(Reading reading);
    void update(Reading newReading, Reading existingReading);
}
