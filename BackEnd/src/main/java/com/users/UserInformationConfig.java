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
            UserInformation iri = new UserInformation( "Irinel", "Urma", "Apps Developer", "irinel.urma@gmail.com","passwordul",AppUserRole.USER);
            UserInformation coci = new UserInformation("Vlad", "Cociorva", "Apps Developer","vlad.cociorva@gmail.com","passwordul",AppUserRole.USER);
            UserInformation aurelian = new UserInformation("Aurelian", "Radu", "Web Developer","aurelian.radu@gmail.com","passwordul",AppUserRole.USER);
            UserInformation arsene = new UserInformation("Robert", "Arsene", "Data Analyst","robert.arsene@gmail.com","passwordul",AppUserRole.USER);
            UserInformation nicu4x4 = new UserInformation("Nicolae", "Capatina", "Apps Developer","nicu.capatina@gmail.com","passwordul",AppUserRole.USER);
            UserInformation radu = new UserInformation("Radu", "Harabagiu", "Service Delivery Manager","radu.harabagiu@gmail","passwordul",AppUserRole.USER);
            UserInformation gramescu = new UserInformation("Rares", "Gramescu", "Software Developer","rares.gramescu@gmail","passwordul",AppUserRole.USER);
            repository.saveAll(List.of(andrei, robert, nicu, nicu4x4, iri, aurelian, coci, arsene, radu, gramescu));
        };
    }
}
