package com.users;

import com.users.tasks.whatObjectives.howObjectives.HowRepository;
import com.users.tasks.whatObjectives.WhatRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserInformationService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final UserInformationRepository userInformationRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final WhatRepository whatRepository;
    private final HowRepository howRepository;
    public List<UserInformation> getUsersInformation() {
        return userInformationRepository.findAll();
    }

    public UserInformation addNewUser(UserInformation userInformation) {
        Optional<UserInformation> userOptional = userInformationRepository.findUserInformationByFirstName(userInformation.getFirstName());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("este deja in baza de date");
        }
        userInformationRepository.save(userInformation);
        return userInformation;
    }

    public void deleteUser(Long userId) {
        boolean exists = userInformationRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("userul cu id-ul" + userId + " nu exista");
        }
        whatRepository.removeWhatInformationsByUserId(userId);
        howRepository.removeHowInformationsByUserId(userId);
        userInformationRepository.deleteById(userId);

    }

    @Transactional
    public UserInformation updateUser(Long userId, UserInformation userInformation) {
        UserInformation user = userInformationRepository.findById(userId).
                orElseThrow(() -> new IllegalStateException("userul cu idul" + userId + " nu exista"));
        String firstName = userInformation.getFirstName();
        if (firstName != null && firstName.length() > 0 && !Objects.equals(user.getFirstName(), firstName)) {
            user.setFirstName(firstName);
        }
        String lastName = userInformation.getLastName();
        if (lastName != null && lastName.length() > 0 && !Objects.equals(user.getLastName(), lastName)) {
            user.setLastName(lastName);
        }
        return user;
    }

    public UserDetails findUserByEmailAndPassword(String email, String password) {
        System.out.println(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserDetails user = userInformationRepository.findByEmail(email).
            orElseThrow(() -> new IllegalStateException("the email doesn't exist in db"));
        if(!encoder.matches(password, user.getPassword())){
            throw new IllegalStateException("invalid credentials");
        }
        return user;
    }

    public UserInformation findUserById(Long userId) {
        UserInformation user = userInformationRepository.findById(userId).
                orElseThrow(() -> new IllegalStateException("userul cu idul" + userId + " nu exista"));
        return user;
    }

    public void testUserCredentials(UserInformation userInformation) {
        Optional<UserInformation> userOptional = userInformationRepository.findUserInformationByFirstName(userInformation.getFirstName());
        if (userOptional.isEmpty()) {
            throw new IllegalStateException("Wrong Username");
        }
        if(!Objects.equals(userOptional.get().getLastName(), userInformation.getLastName())){
            throw new IllegalStateException("Wrong Password");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userInformationRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(UserInformation userInformation){
        boolean userExists = userInformationRepository.findByEmail(userInformation.getEmail())
                .isPresent();
        if(userExists){
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(userInformation.getPassword());

        userInformation.setPassword(encodedPassword);

        userInformationRepository.save(userInformation);

        //TODO: SEND Confirmation token

        return "it works";
    }


}
