package com.registration;

import com.users.AppUserRole;
import com.users.UserInformation;
import com.users.UserInformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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
