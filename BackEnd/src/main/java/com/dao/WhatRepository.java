package com.dao;

import com.entities.WhatInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhatRepository extends JpaRepository<WhatInformation, Long> {
    WhatInformation findWhatInformationByTaskId(Long id);
}
