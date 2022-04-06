package com.users.tasks.evaluate.skills;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SkillsService {
    private final SkillsRepository skillsRepository;

    public List<SkillsInformation> getAll(){
        return skillsRepository.findAll();
    }

    public SkillsInformation addSkill(SkillsInformation skillsInformation){
        skillsRepository.save(skillsInformation);
        return skillsInformation;
    }
}
