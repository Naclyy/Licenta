package com.dao;

import com.entities.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {
    
    Optional<UserInformation> findUserInformationByFirstName(String firstName);
    Optional<UserInformation> findByEmail(String email);
    UserInformation findUserInformationByUserId(Long id);
}
