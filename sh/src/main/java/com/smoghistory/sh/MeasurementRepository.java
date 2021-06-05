package com.smoghistory.sh;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

 @RepositoryRestResource(collectionResourceRel = "measurements", path = "measurements")
    public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
        List<Measurement> findByLocation(@Param("location") String location);
    }

