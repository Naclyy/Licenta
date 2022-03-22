package com.users.tasks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner2(TaskRepository repository){
        return args -> {
            TaskInformation saleForAndrei = new TaskInformation(1L,"Sales must go up by 10%", "Sell more to rich people");
            TaskInformation saleForNicu = new TaskInformation(3L,"Sales must go up by 10%", "Sell more to rich people");
            repository.saveAll(List.of(saleForAndrei, saleForNicu));
        };
    }
}
