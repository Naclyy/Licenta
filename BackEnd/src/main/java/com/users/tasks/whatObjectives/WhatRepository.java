package com.users.tasks.whatObjectives;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WhatRepository extends JpaRepository<WhatInformation, Long> {
    Optional<WhatInformation> findTaskInformationByUserId(Long id);
    Optional<WhatInformation> removeWhatInformationsByUserId(Long id);
}
