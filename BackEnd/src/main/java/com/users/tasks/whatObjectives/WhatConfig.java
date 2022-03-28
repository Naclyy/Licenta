package com.users.tasks.whatObjectives;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class WhatConfig {
    @Bean
    CommandLineRunner commandLineRunner3(WhatRepository repository) {
        return args -> {
            WhatInformation saleForAndrei = new WhatInformation(1L, "Sales must go up by 10%", "20", "30");
            WhatInformation saleForNicu = new WhatInformation(3L, "Sales must go up by 10%", "20", "30");
            repository.saveAll(List.of(saleForAndrei, saleForNicu));
        };
    }
}
