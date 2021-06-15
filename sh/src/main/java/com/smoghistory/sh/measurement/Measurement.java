package com.smoghistory.sh.measurement;
import com.smoghistory.sh.location.Location;

import javax.persistence.*;

@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int value;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="location_id")
    private Location location;

    public Measurement() {}

    public Measurement(int value, Location location) {
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
