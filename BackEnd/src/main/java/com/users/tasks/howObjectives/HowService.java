package com.users.tasks.howObjectives;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class HowService {
    private final HowRepository howRepository;

    public HowInformation addNewTask(HowInformation howInformation){
        howRepository.save(howInformation);
        return howInformation;
    }
    public void removeByUserId(Long id){
        howRepository.removeHowInformationsByUserId(id);
    }
}
