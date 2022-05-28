package com.config.tasks.evaluate.skills;

import com.dao.SkillsRepository;
import com.entities.SkillsInformation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SkillsConfig {
    @Bean
    CommandLineRunner commandLineRunnerSkill(SkillsRepository repository){
        return  args -> {
            repository.saveAll(List.of(new SkillsInformation("Inspiring Others"), new SkillsInformation("Making Complex Decisions"), new SkillsInformation("Identifying Priorities"),
                    new SkillsInformation("Being Open & Receptive")));
        };
    }
}
