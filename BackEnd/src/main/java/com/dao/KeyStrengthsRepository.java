package com.dao;

import com.entities.KeyStrengthsInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyStrengthsRepository extends JpaRepository<KeyStrengthsInformation, Long>
{

}
