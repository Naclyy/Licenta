package com.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {

    // Este echivalentul la SELECT * FROM user WHERE firstName = ?
    Optional<UserInformation> findUserInformationByFirstName(String firstName);
}
