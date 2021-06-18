package com.smoghistory.sh.measurement;

import java.util.List;

import com.smoghistory.sh.location.Location;
import com.smoghistory.sh.location.LocationRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MeasurementController {

    private final MeasurementRepository repository;
    private final LocationRepository loc;

    MeasurementController(MeasurementRepository repository, LocationRepository loc
    ) {
        this.repository = repository;
        this.loc = loc;
    }

    @GetMapping("/measurements")
    List<Measurement> all() {
        return repository.findAll();
    }

//    @PostMapping("/measurements")
//    Measurement newMeasurement(@RequestBody Measurement newMeasurement) {
//        return repository.save(newMeasurement);
//    }

    @PostMapping("locations/{id}/measurements")
    Measurement newMeasurement(@PathVariable long id, @RequestBody Measurement newMeasurement) {
        Location location = loc.getById(id);
        newMeasurement.setLocation(location);
        return repository.save(newMeasurement);
    }

    @GetMapping("locations/{id}/measurements")
    List<Measurement> all(@PathVariable long id) {
        return repository.findByLocationId(id);
    }

    @GetMapping("/measurements/{id}")
    Measurement one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MeasurementNotFoundException(id));
    }

    @DeleteMapping("/Measurements/{id}")
    void deleteMeasurement(@PathVariable Long id) {
        repository.deleteById(id);
    }
}