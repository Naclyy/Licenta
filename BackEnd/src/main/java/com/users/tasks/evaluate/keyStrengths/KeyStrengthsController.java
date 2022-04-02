package com.users.tasks.evaluate.keyStrengths;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/keyStrengths")
public class KeyStrengthsController {
    private final KeyStrengthsService keyStrengthsService;

    @Autowired
    public KeyStrengthsController(KeyStrengthsService keyStrengthsService){
        this.keyStrengthsService = keyStrengthsService;
    }

    @PostMapping("/add")
    public ResponseEntity<KeyStrengthsInformation> addNewKeyStrengths(@RequestBody KeyStrengthsInformation keyStrengthsInformation){
        KeyStrengthsInformation keyStrengths = keyStrengthsService.addKeyStrengths(keyStrengthsInformation);
        return new ResponseEntity<>(keyStrengths, HttpStatus.CREATED);
    }
}
