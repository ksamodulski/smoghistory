package com.smoghistory.sh.location;

import com.smoghistory.sh.measurement.Measurement;
import com.smoghistory.sh.measurement.MeasurementNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class LocationController {

    private final LocationRepository repository;


    LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/locations")
    List<Location> all() {
        return repository.findAll();
    }

    @GetMapping("/locations/{id}")
    Location one(@PathVariable long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MeasurementNotFoundException(id));
    }

    @PostMapping("/locations")
    Location newLocation(@RequestBody Location newLocation) {
        return repository.save(newLocation);
    }

    @DeleteMapping("/locations/{id}")
    void deleteLocation(@PathVariable long id) {
        repository.deleteById(id);
    }
}