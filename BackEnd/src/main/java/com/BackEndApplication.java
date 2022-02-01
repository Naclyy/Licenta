package com;

import com.users.UserInformationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//// Daca clasa pe care fac controller nu este in aceasi package trebuie adaugata o linie similara cu cea de jos
//@ComponentScan(basePackageClasses = UserInformationController.class)
public class BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }

}
