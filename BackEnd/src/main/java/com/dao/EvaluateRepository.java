package com.dao;

import com.entities.EvaluateInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluateRepository extends JpaRepository<EvaluateInformation, Long> {
}
