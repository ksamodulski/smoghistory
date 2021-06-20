package com.smoghistory.sh.location;
import com.smoghistory.sh.measurement.Measurement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String country;
    private String city;
    private int lat;
    private int lon;
    @OneToMany(
            mappedBy = "location",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Measurement> measurements = new ArrayList<>();

    public Location() {}

    public Location(long id, String country, String city, int lat, int lon) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
    }

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public void addMeasurement(Measurement m) {
        measurements.add(m);
        m.setLocation(this);
    }

    public void removeMeasurement(Measurement m) {
        measurements.remove(m);
        m.setLocation(null);
    }

}
