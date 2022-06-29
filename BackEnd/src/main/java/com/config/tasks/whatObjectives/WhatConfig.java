package com.config.tasks.whatObjectives;


import com.dao.WhatRepository;
import com.entities.WhatInformation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class WhatConfig {
    @Bean
    CommandLineRunner commandLineRunner2(WhatRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new WhatInformation("Create a new app", "19/04/2022", "19/06/2022"),
                    new WhatInformation("Add features to App_Name", "19/04/2022", "19/08/2022")
            ));
        };
    }
}