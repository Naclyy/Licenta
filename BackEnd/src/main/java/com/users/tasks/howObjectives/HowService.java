package com.users.tasks.howObjectives;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class HowService {
    private final HowRepository howRepository;

    public HowInformation addNewTask(HowInformation howInformation){
        howRepository.save(howInformation);
        return howInformation;
    }
    public List<HowInformation> getHowObjectivesByUserId(Long id){
        return howRepository.findHowInformationByUserId(id);
    }
    public void deleteTask(Long taskId){
        boolean exists = howRepository.existsById(taskId);
        if (!exists) {
            throw new IllegalStateException("taskul cu id-ul" + taskId + " nu exista");
        }
        howRepository.deleteById(taskId);
    }
    public void removeByUserId(Long id){
        howRepository.removeHowInformationsByUserId(id);
    }
}
