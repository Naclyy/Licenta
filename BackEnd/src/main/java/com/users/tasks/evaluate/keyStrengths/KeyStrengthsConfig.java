package com.users.tasks.evaluate.keyStrengths;

import com.users.tasks.evaluate.EvaluateInformation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class KeyStrengthsConfig {
    @Bean
    CommandLineRunner commandLineRunnerKeyStrengths(KeyStrengthsRepository repository){
        return args -> {
            repository.saveAll(List.of(new KeyStrengthsInformation("Defining Targets"), new KeyStrengthsInformation("Activities Planning"), new KeyStrengthsInformation("Activities Executing"), new KeyStrengthsInformation("Reporting/Feedback"), new KeyStrengthsInformation("Others")));
        };
    }
}
