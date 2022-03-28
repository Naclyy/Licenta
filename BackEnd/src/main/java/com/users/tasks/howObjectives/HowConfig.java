package com.users.tasks.howObjectives;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HowConfig {
    @Bean
    CommandLineRunner commandLineRunner2(HowRepository repository){
        return args -> {
            HowInformation saleForAndrei = new HowInformation(1L, "Sell more to rich people","20","30");
            HowInformation saleForAndrei2 = new HowInformation(1L, "Sell more to rich people","20","30");
            HowInformation saleForNicu = new HowInformation(3L,"Sell more to rich people","20","30");
            repository.saveAll(List.of(saleForAndrei,saleForAndrei2, saleForNicu));
        };
    }
}
