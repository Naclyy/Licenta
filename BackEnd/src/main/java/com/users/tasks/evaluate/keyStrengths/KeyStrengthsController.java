package com.users.tasks.evaluate.keyStrengths;


import com.users.tasks.howObjectives.HowInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/keyStrengths")
public class KeyStrengthsController {
    private final KeyStrengthsService keyStrengthsService;

    @Autowired
    public KeyStrengthsController(KeyStrengthsService keyStrengthsService){
        this.keyStrengthsService = keyStrengthsService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<KeyStrengthsInformation>> getAllKeyStrength(){
        return new ResponseEntity<>(keyStrengthsService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<KeyStrengthsInformation> addNewKeyStrengths(@RequestBody KeyStrengthsInformation keyStrengthsInformation){
        KeyStrengthsInformation keyStrengths = keyStrengthsService.addKeyStrengths(keyStrengthsInformation);
        return new ResponseEntity<>(keyStrengths, HttpStatus.CREATED);
    }
}
