package com.users.tasks.evaluate.keyStrengths;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class KeyStrengthsService {
    private  final KeyStrengthsRepository keyStrengthsRepository;

    public List<KeyStrengthsInformation> getAll(){
        return keyStrengthsRepository.findAll();
    }

    public KeyStrengthsInformation addKeyStrengths(KeyStrengthsInformation keyStrengthsInformation){
        keyStrengthsRepository.save(keyStrengthsInformation);
        return keyStrengthsInformation;
    }
}
