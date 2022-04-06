package com.users.tasks.evaluate;

import com.users.tasks.howObjectives.HowInformation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EvaluateConfig {
    @Bean
    CommandLineRunner commandLineRunnerEvaluate(EvaluateRepository repository){
        return args -> {
            repository.saveAll(List.of(new EvaluateInformation(1L,1L, 1L, 1L, null, 1L, null, 1L, 1L, 1L, null), new EvaluateInformation(2L,1L, 1L, 1L, null, 1L, null, 1L, 1L, 1L, null)));
        };
    }
}
