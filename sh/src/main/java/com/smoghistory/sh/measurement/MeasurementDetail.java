package com.smoghistory.sh.measurement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class MeasurementDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String type;
    long value;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "measurement_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Measurement measurement;

    public MeasurementDetail(long id, String type, long value, Measurement measurement) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.measurement = measurement;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }
}
