package com.users.tasks.howObjectives;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/howTask")
public class HowController {
    private final HowService howService;

    @Autowired
    public HowController(HowService howService){
        this.howService = howService;
    }

    @GetMapping("/findAll/{id}")
    public ResponseEntity<List<HowInformation>> getHowObjectivesByUserId(@PathVariable("id") Long id){
        return new ResponseEntity<>(howService.getHowObjectivesByUserId(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HowInformation> addNewTask(@RequestBody HowInformation howInformation){
        HowInformation task = howService.addNewTask(howInformation);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/deleteByUserId/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId){
        howService.removeByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(path = "/delete/{taskId}")
    public ResponseEntity<?> deleteTaskByTaskId(@PathVariable("taskId") Long taskId){
        howService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
