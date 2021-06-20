package com.smoghistory.sh.measurement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MeasurementDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private MeasurementDetailType type;
    private long value;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "measurement_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Measurement measurement;

    public MeasurementDetail() {
    }

    public MeasurementDetail(long id, MeasurementDetailType type, long value, Measurement measurement) {
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

    public MeasurementDetailType getType() {
        return type;
    }

    public void setType(MeasurementDetailType type) {
        this.type = type;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }


}
