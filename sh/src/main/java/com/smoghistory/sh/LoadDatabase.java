package com.smoghistory.sh;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

//    @Bean
//    CommandLineRunner initLocation(LocationRepository repository) {
//        return args -> {
//            log.info("Preloading " + repository.save(new Location("LUB001", "PL", "Lublin", 50,49)));
//        };
//    }
//
//    @Bean
//    CommandLineRunner initMeasurement(MeasurementRepository repository) {
//        return args -> {
//            log.info("Preloading " + repository.save(new Measurement(11, "LUB001")));
//            log.info("Preloading " + repository.save(new Measurement(15, 2)));
//        };
//    }
}
