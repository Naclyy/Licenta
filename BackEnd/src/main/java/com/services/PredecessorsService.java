package com.services;

import com.entities.PredecessorsInformation;
import com.dao.PredecessorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PredecessorsService {
    private final PredecessorsRepository predecessorsRepository;

    public PredecessorsInformation addNewPredecessor(PredecessorsInformation predecessorsInformation){
        predecessorsRepository.save(predecessorsInformation);
        return predecessorsInformation;
    }
}
