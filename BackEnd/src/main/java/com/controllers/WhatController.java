package com.controllers;

import com.entities.WhatInformation;
import com.services.WhatService;
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


    @PostMapping("/addToUser/{id}")
    public ResponseEntity<WhatInformation>  addNewTask(@RequestBody Long task_id, @PathVariable("id") Long user_id){
        System.out.println(user_id);
        System.out.println(task_id);

        WhatInformation whatTask = whatService.addTaskToUser(task_id, user_id);
        return new ResponseEntity<>(whatTask, HttpStatus.CREATED);
    }
    @PostMapping("/add")
    public ResponseEntity<WhatInformation> addNewTask(@RequestBody WhatInformation whatInformation){
        WhatInformation whatTask = whatService.addNewTask(whatInformation);
        return new ResponseEntity<>(whatTask, HttpStatus.CREATED);
    }

    @GetMapping("/findAllForUser/{id}")
    public ResponseEntity<List<WhatInformation>> getWhatObjectivesByUserId(@PathVariable("id") Long id){
        return new ResponseEntity<>(whatService.getWhatObjectivesByUserId(id), HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<WhatInformation>> getAllWhatObjective(){
        return new ResponseEntity<>(whatService.getAll(), HttpStatus.OK);
    }
    @DeleteMapping(path = "/delete/{taskId}")
    public ResponseEntity<?> deleteTaskByTaskId(@PathVariable("taskId") Long taskId){
        whatService.deleteTask(taskId);
        System.out.println("intra pe controller");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(path = "/deleteFromUser/{user_id}")
    public ResponseEntity<?> deleteTaskFromUser(@RequestBody Long task_id, @PathVariable("user_id") Long user_id){
        whatService.deleteTaskFromUser(user_id, task_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
