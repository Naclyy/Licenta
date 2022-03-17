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
            UserInformation andrei = new UserInformation( "Andrei", "Zaharia", "Team Leader", "andrei.zaharia@gmail.com","$2a$12$43DNgvHAWmxwDKIC3oZpz.IevyovvbpMcZ5b8n6WfyAarW.Lh1wDW",AppUserRole.ADMIN);
            UserInformation robert = new UserInformation("Robert", "Vacaru", "Web Developer","robert.vacaru@gmail.com","passwordul",AppUserRole.USER);
            UserInformation nicu = new UserInformation("Nicolae", "Alexandrescu", "Web Developer","nicu.alexandrescu@gmail.com","passwordul",AppUserRole.USER);
            UserInformation nicu4x4 = new UserInformation("Nicolae", "Capatina", "Apps Developer","nicu.capatina@gmail.com","passwordul",AppUserRole.USER);
           repository.saveAll(List.of(andrei, robert,nicu, nicu4x4));
        };
    }
}
