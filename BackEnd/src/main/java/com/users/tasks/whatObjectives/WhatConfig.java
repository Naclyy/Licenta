package com.users.tasks.whatObjectives;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;
@Configuration
public class WhatConfig {
    @Bean
    CommandLineRunner commandLineRunner2(WhatRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new WhatInformation("Sales must go up by 10%", "19/04/2022", "19/06/2022"),
                    new WhatInformation("We must build a new frontend", "19/04/2022", "19/08/2022")
            ));
        };
    }
}
