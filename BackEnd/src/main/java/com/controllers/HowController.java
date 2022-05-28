package com.controllers;

import com.entities.dto.AddHowTask;
import com.entities.dto.Graph;
import com.entities.HowInformation;
import com.services.HowService;
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
    public HowController(HowService howService) {
        this.howService = howService;
    }

    @GetMapping("/findAll/{id}")
    public ResponseEntity<List<HowInformation>> getHowObjectivesByUserId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(howService.getHowObjectivesByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/findAllWhatId/{id}")
    public ResponseEntity<List<HowInformation>> getHowObjectivesByWhatId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(howService.getHowObjectivesByWhatId(id), HttpStatus.OK);
    }

    @GetMapping("/graph/{id}")
    public ResponseEntity<List<Graph>> estimateTaskTime(@PathVariable("id") Long what_id) {
        return new ResponseEntity<>(howService.CalculateGraph(what_id), HttpStatus.OK);
    }

    @PostMapping("/add/{user_id}/{what_id}")
    public ResponseEntity<HowInformation> addNewTask(@RequestBody AddHowTask task, @PathVariable("user_id") Long user_id,
                                                     @PathVariable("what_id") Long what_id) {

        HowInformation howTask = howService.addNewTask(new HowInformation(what_id, user_id, task.getObjectives(), task.getEstimatedTime()));
        return new ResponseEntity<>(howTask, HttpStatus.CREATED);
    }

    @PostMapping("/addPredecessor")
    public ResponseEntity<?> addNewTask(@RequestBody Long predecessor_id) throws InterruptedException {
        System.out.println(predecessor_id);
        howService.addPredecessor(predecessor_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteByUserId/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId) {
        howService.removeByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{taskId}")
    public ResponseEntity<?> deleteTaskByTaskId(@PathVariable("taskId") Long taskId) {
        howService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
