package com.users.tasks.whatObjectives.userWhatJoin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class JoinTableService {
    private final JoinTableRepository joinTableRepository;

    public JoinTableInformation addNewPredecessor(JoinTableInformation joinTableInformation){
        joinTableRepository.save(joinTableInformation);
        return joinTableInformation;
    }

}
