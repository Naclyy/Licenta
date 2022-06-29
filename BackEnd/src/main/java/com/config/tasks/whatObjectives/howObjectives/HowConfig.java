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
                    new HowInformation(1L,2L, "Test the App",9),
                    new HowInformation(1L,3L, "Build the Back End",12),
                    new HowInformation(1L,4L, "Create the DB",8),
                    new HowInformation(1L,5L, "Create Java Endpoints",9),
                    new HowInformation(1L,6L, "Add the CSS",6),
                    new HowInformation(1L,7L, "Create Admin Page",5),
                    new HowInformation(2L,1L, "Build the Back End",5)
                    ));
        };
    }
}
