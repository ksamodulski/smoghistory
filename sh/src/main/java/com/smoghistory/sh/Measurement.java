package com.smoghistory.sh;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int source;
    private String location;
    private String measurementType;
    private int value;

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
