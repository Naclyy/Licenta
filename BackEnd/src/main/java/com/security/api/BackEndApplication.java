package com.security.api;

import com.users.AccountInformations;
import com.users.Coach;
import com.users.UserInformations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class BackEndApplication {

    @GetMapping("/")
    public String login(){
        return "Authentification works";
    }
    @GetMapping("/getTrainers")
    public List<Coach> getTrainers(){
        List<Coach> testing = new LinkedList<>();
        Coach firstCoach = new Coach(new AccountInformations("Naclyy","naclyy"), new UserInformations("Andrei", "Zaharia"));
        Coach secondCoach = new Coach(new AccountInformations("MonkeyKing","monkey"), new UserInformations("Robert", "Vacaru"));
        testing.add(firstCoach);
        testing.add(secondCoach);
        System.out.println(testing);
        return testing;
    }
    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }

}
