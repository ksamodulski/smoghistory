package com.smoghistory.sh.measurement;

import java.util.List;
import java.util.Optional;

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

    MeasurementController(MeasurementRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/measurements")
    List<Measurement> all() {
        return repository.findAll();
    }

    @PostMapping("/measurements")
    Measurement newMeasurement(@RequestBody Measurement newMeasurement) {
        return repository.save(newMeasurement);
    }

    @PostMapping("locations/{id}/measurements")
    Measurement newMeasurement(@PathVariable long id, @RequestBody Measurement newMeasurement) {
        newMeasurement.setLocation(new Location(id,"","",0,0));
        return repository.save(newMeasurement);
    }

    @GetMapping("/measurements/{id}")
    Measurement one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MeasurementNotFoundException(id));
    }

    @GetMapping("locations/{id}/measurements/")
    List<Measurement> two(@PathVariable Long id) {
        return repository.findByLocationId(id);
    }


//    @PutMapping("/measurements/{id}")
//    Measurement replaceMeasurement(@RequestBody Measurement newMeasurement, @PathVariable Long id) {
//        return repository.findById(id)
//                .map(Measurement -> {
//                    Measurement.setLocation(newMeasurement.getLocation());
//                    Measurement.setValue(newMeasurement.getValue());
//                    return repository.save(Measurement);
//                })
//                .orElseGet(() -> {
//                    newMeasurement.setId(id);
//                    return repository.save(newMeasurement);
//                });
//    }

    @DeleteMapping("/Measurements/{id}")
    void deleteMeasurement(@PathVariable Long id) {
        repository.deleteById(id);
    }
}