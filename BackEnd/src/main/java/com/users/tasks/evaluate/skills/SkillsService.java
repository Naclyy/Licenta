package com.users.tasks.evaluate.skills;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SkillsService {
    private final SkillsRepository skillsRepository;

    public SkillsInformation addSkill(SkillsInformation skillsInformation){
        skillsRepository.save(skillsInformation);
        return skillsInformation;
    }
}
