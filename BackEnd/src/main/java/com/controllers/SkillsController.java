package com.controllers;

import com.services.SkillsService;
import com.entities.SkillsInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/skills")
public class SkillsController {
    private final SkillsService skillsService;

    @Autowired
    public SkillsController(SkillsService skillsService){
        this.skillsService = skillsService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SkillsInformation>> getAllSkills(){
        return new ResponseEntity<>(skillsService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SkillsInformation> addSkill(@RequestBody SkillsInformation skillsInformation){
        SkillsInformation skills = skillsService.addSkill(skillsInformation);
        return new ResponseEntity<>(skills, HttpStatus.CREATED);
    }
}
