package com.users.tasks.whatObjectives;

import com.users.tasks.whatObjectives.howObjectives.HowInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WhatRepository extends JpaRepository<WhatInformation, Long> {
    WhatInformation findWhatInformationByTaskId(Long id);
}
