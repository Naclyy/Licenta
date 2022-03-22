package com.users.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public ResponseEntity<TaskInformation> addNewTask(@RequestBody TaskInformation taskInformation){
        TaskInformation task = taskService.addNewTask(taskInformation);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
}
