package com.users.tasks.evaluate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/evaluate")
public class EvaluateController {
    private final EvaluateService evaluateService;

    @Autowired
    public EvaluateController(EvaluateService evaluateService){
        this.evaluateService = evaluateService;
    }

    @PostMapping("/add")
    public ResponseEntity<EvaluateInformation> addRecord(@RequestBody EvaluateInformation evaluateInformation){
        EvaluateInformation evaluate = evaluateService.addRecord(evaluateInformation);
        return new ResponseEntity<>(evaluate, HttpStatus.CREATED);
    }
}
