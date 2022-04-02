package com.users.tasks.evaluate.skills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/skills")
public class SkillsController {
    private final SkillsService skillsService;

    @Autowired
    public SkillsController(SkillsService skillsService){
        this.skillsService = skillsService;
    }

    @PostMapping("/add")
    public ResponseEntity<SkillsInformation> addSkill(@RequestBody SkillsInformation skillsInformation){
        SkillsInformation skills = skillsService.addSkill(skillsInformation);
        return new ResponseEntity<>(skills, HttpStatus.CREATED);
    }
}
