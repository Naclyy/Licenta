package com.config.tasks.whatObjectives.userWhatJoin;

import com.dao.JoinTableRepository;
import com.entities.JoinTableInformation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class JoinTableConfig {
    @Bean
    CommandLineRunner commandLineRunnerJoinTable(JoinTableRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new JoinTableInformation(1L, 1L),
                    new JoinTableInformation(2L, 1L),
                    new JoinTableInformation(3L, 1L),
                    new JoinTableInformation(4L, 1L),
                    new JoinTableInformation(5L, 1L),
                    new JoinTableInformation(6L, 1L),
                    new JoinTableInformation(7L, 1L),
                    new JoinTableInformation(1L, 2L)
            ));
        };
    }

}
