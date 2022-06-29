package com.services;

import com.entities.enums.AppUserRole;
import com.entities.UserInformation;
import com.entities.requests.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserInformationService userInformationService;
    private final EmailValidator emailValidator;

    public UserInformation register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return userInformationService.signUpUser(new UserInformation(
                request.getFirstName(),
                request.getLastName(),
                request.getPosition(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER));
    }
}
