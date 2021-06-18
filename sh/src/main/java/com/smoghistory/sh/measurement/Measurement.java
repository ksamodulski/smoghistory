package com.smoghistory.sh.measurement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.smoghistory.sh.location.Location;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Measurement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int value;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "location_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Location location;

    public Measurement() {}

    public Measurement(long id, int value, Location location) {
        this.id = id;
        this.value = value;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @JsonIgnore
    public Location getLocation() {
        return location;
    }

    @JsonSetter
    public void setLocation(Location location) {
        this.location = location;
    }


}
