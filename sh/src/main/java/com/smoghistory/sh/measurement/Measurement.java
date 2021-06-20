package com.smoghistory.sh.measurement;
import com.fasterxml.jackson.annotation.*;
import com.smoghistory.sh.location.Location;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Measurement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonProperty(required = true)
    private Date date;

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

    @JsonGetter
    public long locationId(){
        return location.getId();
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
