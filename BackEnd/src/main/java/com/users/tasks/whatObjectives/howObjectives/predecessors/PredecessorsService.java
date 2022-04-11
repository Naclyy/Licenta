package com.users.tasks.whatObjectives.howObjectives.predecessors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
