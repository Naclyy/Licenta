package com.users.tasks.evaluate.keyStrengths;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class KeyStrengthsService {
    private  final KeyStrengthsRepository keyStrengthsRepository;

    public KeyStrengthsInformation addKeyStrengths(KeyStrengthsInformation keyStrengthsInformation){
        keyStrengthsRepository.save(keyStrengthsInformation);
        return keyStrengthsInformation;
    }
}
