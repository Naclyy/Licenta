package com.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserInformationController {

    private final UserInformationService userInformationService;

    @Autowired
    public UserInformationController(UserInformationService userInformationService) {
        this.userInformationService = userInformationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserInformation>> getUsersInformation(){
        return new ResponseEntity<>(userInformationService.getUsersInformation(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserInformation> getUserInformation(@PathVariable("id") Long id){
        UserInformation user = userInformationService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserInformation> registerNewUser(@RequestBody UserInformation userInformation){
        UserInformation user = userInformationService.addNewUser(userInformation);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> testUserCredential(@RequestBody UserInformation userInformation){
        System.out.println(userInformation);
        userInformationService.testUserCredentials(userInformation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId){
        userInformationService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update/{userId}")
    public ResponseEntity<?> updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName){
        userInformationService.updateUser(userId, firstName, lastName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
