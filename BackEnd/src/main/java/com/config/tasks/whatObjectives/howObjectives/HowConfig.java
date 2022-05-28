package com.config.tasks.whatObjectives.howObjectives;

import com.dao.HowRepository;
import com.entities.HowInformation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HowConfig {
    @Bean
    CommandLineRunner commandLineRunner3(HowRepository repository){
        return args -> {
            repository.saveAll(List.of(
                    new HowInformation(1L,1L, "Build the Front End",7),
                    new HowInformation(1L,2L, "Vacheru",9),
                    new HowInformation(1L,3L, "Alex",12),
                    new HowInformation(1L,4L, "Capatina",8),
                    new HowInformation(1L,5L, "iri",9),
                    new HowInformation(1L,6L, "aurelian",6),
                    new HowInformation(1L,7L, "coci",5),
                    new HowInformation(2L,1L, "Build the Back End",5)
                    ));
        };
    }
}
