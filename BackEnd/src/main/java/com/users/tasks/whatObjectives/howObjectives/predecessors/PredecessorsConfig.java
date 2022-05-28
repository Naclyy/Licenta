package com.users.tasks.whatObjectives.howObjectives.predecessors;

import com.users.tasks.whatObjectives.howObjectives.HowInformation;
import com.users.tasks.whatObjectives.howObjectives.HowRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class PredecessorsConfig {
    @Bean
    CommandLineRunner commandLineRunner4(PredecessorsRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new PredecessorsInformation(3L, 1L),
                    new PredecessorsInformation(4L, 1L),
                    new PredecessorsInformation(4L, 2L),
                    new PredecessorsInformation(5L, 4L),
                    new PredecessorsInformation(6L, 3L),
                    new PredecessorsInformation(6L, 5L),
                    new PredecessorsInformation(7L, 5L)
            ));
        };
    }

}
