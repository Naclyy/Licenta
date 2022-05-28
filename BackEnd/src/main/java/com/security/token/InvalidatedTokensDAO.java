package com.security.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface InvalidatedTokensDAO extends JpaRepository<InvalidatedToken, String> {
    Optional<InvalidatedToken> findByToken(String token);
}
