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

    @PostMapping
    public void registerNewUser(@RequestBody UserInformation userInformation){
        userInformationService.addNewUser(userInformation);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userInformationService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName){
        userInformationService.updateUser(userId, firstName, lastName);
    }
}
