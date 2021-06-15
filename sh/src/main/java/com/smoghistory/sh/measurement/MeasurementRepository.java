package com.smoghistory.sh.measurement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface MeasurementRepository extends JpaRepository<Measurement, Long> {
        public List<Measurement> findByLocationId(long id);
   }

