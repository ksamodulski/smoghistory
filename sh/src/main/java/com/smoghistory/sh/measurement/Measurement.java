package com.smoghistory.sh.measurement;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.smoghistory.sh.location.Location;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Measurement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(
            mappedBy = "measurement",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MeasurementDetail> measurementDetailList;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "location_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Location location;

    public Measurement() {}

    public Measurement(long id, List<MeasurementDetail> measurementDetailList, Location location) {
        this.id = id;
        this.measurementDetailList = measurementDetailList;
        this.location = location;
    }

    public void linkDetails(){
        for (MeasurementDetail detail : measurementDetailList) {
            detail.setMeasurement(this);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonIgnore
    public Location getLocation() {
        return location;
    }

    @JsonSetter
    public void setLocation(Location location) {
        this.location = location;
    }

    public List<MeasurementDetail> getMeasurementDetailList() {
        return measurementDetailList;
    }

    public void setMeasurementDetailList(List<MeasurementDetail> measurementDetailList) {
        this.measurementDetailList = measurementDetailList;
    }

}
