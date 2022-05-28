package com.services;


import com.entities.EvaluateInformation;
import com.dao.EvaluateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EvaluateService {
    private final EvaluateRepository evaluateRepository;

    public EvaluateInformation addRecord(EvaluateInformation evaluateInformation){
        evaluateRepository.save(evaluateInformation);
        return  evaluateInformation;
    }
}
