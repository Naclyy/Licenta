package com.users.tasks.whatObjectives;

import com.users.tasks.whatObjectives.howObjectives.HowInformation;
import com.users.tasks.whatObjectives.howObjectives.predecessors.PredecessorsInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/whatTask")
public class WhatController {
    private final WhatService whatService;

    @Autowired
    public WhatController(WhatService whatService){
        this.whatService = whatService;
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<WhatInformation> addNewTask(@RequestBody WhatInformation whatInformation, @PathVariable("id") Long user_id){
        WhatInformation whatTask = whatService.addNewTask(whatInformation, user_id);
        return new ResponseEntity<>(whatTask, HttpStatus.CREATED);
    }
    @GetMapping("/findAll/{id}")
    public ResponseEntity<List<WhatInformation>> getWhatObjectivesByUserId(@PathVariable("id") Long id){
        return new ResponseEntity<>(whatService.getWhatObjectivesByUserId(id), HttpStatus.OK);
    }
    @DeleteMapping(path = "/delete/{taskId}")
    public ResponseEntity<?> deleteTaskByTaskId(@PathVariable("taskId") Long taskId){
        whatService.deleteTask(taskId);
        System.out.println("intra pe controller");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
