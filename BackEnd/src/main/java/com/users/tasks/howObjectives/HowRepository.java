package com.users.tasks.howObjectives;

import com.users.tasks.whatObjectives.WhatInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HowRepository extends JpaRepository<HowInformation, Long> {
    List<HowInformation> findHowInformationByUserId(Long id);
    Optional<HowInformation> removeHowInformationsByUserId(Long id);
}
