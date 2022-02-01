package com.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserInformationConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserInformationRepository repository){
        return args -> {
            UserInformation andrei = new UserInformation( "Andrei", "Zaharia");
            UserInformation robert = new UserInformation("Robert", "Vacaru");

            repository.saveAll(List.of(andrei, robert));
        };
    }
}
