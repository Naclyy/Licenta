package com.users;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserInformationService {

    private final UserInformationRepository userInformationRepository;

    public UserInformationService(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }


    public List<UserInformation> getUsersInformation() {
        return userInformationRepository.findAll();
    }

    public void addNewUser(UserInformation userInformation) {
        Optional<UserInformation> userOptional = userInformationRepository.findUserInformationByFirstName(userInformation.getFirstName());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("este deja in baza de date");
        }
        userInformationRepository.save(userInformation);
    }

    public void deleteUser(Long userId) {
        boolean exists = userInformationRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("userul cu id-ul" + userId + " nu exista");
        }
        userInformationRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String firstName, String lastName) {
        UserInformation user = userInformationRepository.findById(userId).
                orElseThrow(() -> new IllegalStateException("userul cu idul" + userId + " nu exista"));
        if (firstName != null && firstName.length() > 0 && !Objects.equals(user.getFirstName(), firstName)) {
            user.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() > 0 && !Objects.equals(user.getLastName(), lastName)) {
            user.setLastName(lastName);
        }
    }

    public UserInformation findUserById(Long userId) {
        UserInformation user = userInformationRepository.findById(userId).
                orElseThrow(() -> new IllegalStateException("userul cu idul" + userId + " nu exista"));
        return user;
    }
}
