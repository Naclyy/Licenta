package com.controllers;

import com.registration.RegistrationRequest;
import com.registration.RegistrationService;
import com.entities.dto.Login;
import com.entities.UserInformation;
import com.services.UserInformationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/authentication")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;
    private UserInformationService userInformationService;

    @PostMapping("/register")
    public ResponseEntity<UserInformation> register(@RequestBody RegistrationRequest request){
        UserInformation user = registrationService.register(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/auth")
    public UserDetails loginUser(@RequestBody Login login){
        System.out.println("ok");
        return userInformationService.findUserByEmailAndPassword(login.getEmail(), login.getPassword());
    }
}
