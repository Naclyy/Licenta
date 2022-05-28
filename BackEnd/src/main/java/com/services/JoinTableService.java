package com.services;

import com.dao.JoinTableRepository;
import com.entities.JoinTableInformation;
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
