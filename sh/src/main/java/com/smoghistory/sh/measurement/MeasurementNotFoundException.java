package com.smoghistory.sh.measurement;


public class MeasurementNotFoundException extends RuntimeException {

    public MeasurementNotFoundException(Long id) {
        super("Could not find measurement " + id);
    }
}
