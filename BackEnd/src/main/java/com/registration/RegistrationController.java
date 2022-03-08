package com.registration;

import com.users.Login;
import com.users.UserInformation;
import com.users.UserInformationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
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
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request){
        System.out.println(registrationService.register(request));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/auth")
    public UserDetails loginUser(@RequestBody Login login){
        System.out.println("ok");
        return userInformationService.findUserByEmailAndPassword(login.getEmail(), login.getPassword());
    }
}
