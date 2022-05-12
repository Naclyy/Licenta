package com.users.tasks.whatObjectives.howObjectives;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
public class HowConfig {
    @Bean
    CommandLineRunner commandLineRunner3(HowRepository repository){
        return args -> {
            repository.saveAll(List.of(
                    new HowInformation(1L,1L, "Zah",7),
                    new HowInformation(1L,2L, "Vacheru",9),
                    new HowInformation(1L,3L, "Alex",12),
                    new HowInformation(1L,4L, "Capatina",8),
                    new HowInformation(1L,5L, "iri",9),
                    new HowInformation(1L,6L, "aurelian",6),
                    new HowInformation(1L,7L, "coci",5),
                    new HowInformation(2L,1L, "Sell more to rich people",5)
                    ));
        };
    }
}
