package com.users.tasks.whatObjectives;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/whatTask")
public class WhatController {
    private final WhatService whatService;

    @Autowired
    public WhatController(WhatService whatService){
        this.whatService = whatService;
    }

    @PostMapping("/add")
    public ResponseEntity<WhatInformation> addNewTask(@RequestBody WhatInformation whatInformation){
        WhatInformation whatTask = whatService.addNewTask(whatInformation);
        return new ResponseEntity<>(whatTask, HttpStatus.CREATED);
    }
}
