package com.users.tasks.whatObjectives;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class WhatService {
    private final WhatRepository whatRepository;

    public WhatInformation addNewTask(WhatInformation whatInformation){
        whatRepository.save(whatInformation);
        return whatInformation;
    }
}
