package com.users.tasks.evaluate;


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
