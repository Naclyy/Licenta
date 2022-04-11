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
                    new HowInformation(1L,1L, "Sell more to rich people",7),
                    new HowInformation(1L,2L, "Sell more to rich people",9),
                    new HowInformation(1L,3L, "Sell more to rich people",12),
                    new HowInformation(1L,4L, "Sell more to rich people",8),
                    new HowInformation(1L,5L, "Sell more to rich people",9),
                    new HowInformation(1L,6L, "Sell more to rich people",6),
                    new HowInformation(1L,7L, "Sell more to rich people",5)
                    ));
        };
    }
}
