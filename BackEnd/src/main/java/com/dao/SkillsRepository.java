package com.dao;

import com.entities.SkillsInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository  extends JpaRepository<SkillsInformation, Long> {
}
