package com.services;

import com.entities.WhatInformation;
import com.dao.WhatRepository;
import com.entities.HowInformation;
import com.dao.HowRepository;
import com.entities.JoinTableInformation;
import com.dao.JoinTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class WhatService {
    private final WhatRepository whatRepository;
    private final JoinTableRepository joinTableRepository;
    private final HowRepository howRepository;
    public List<WhatInformation> getAll() {
        return whatRepository.findAll();
    }


    public WhatInformation addTaskToUser(Long task_id, Long user_id){
        joinTableRepository.save(new JoinTableInformation(user_id, task_id));
        return whatRepository.findWhatInformationByTaskId(task_id);
    }

    String convertToDate(String receivedDate){
        int s1 = receivedDate.indexOf('-');
        int s2 = receivedDate.lastIndexOf('-');
        String year = receivedDate.substring(0, s1);
        String month = receivedDate.substring(s1 + 1, s2);
        String day = receivedDate.substring(s2 + 1);
        return day + "/" + month + "/" + year;
    }

    public WhatInformation addNewTask(WhatInformation whatInformation){
        whatInformation.setDateAdded(convertToDate(whatInformation.getDateAdded()));
        whatInformation.setDeadline(convertToDate(whatInformation.getDeadline()));
        WhatInformation whatTask = whatRepository.save(whatInformation);
        return whatInformation;
    }
    public List<WhatInformation> getWhatObjectivesByUserId(Long user_id){
        List<JoinTableInformation> joinTable = joinTableRepository.findJoinTableInformationByUserId(user_id);
        List<WhatInformation> whatTasks = new LinkedList<>();

        for(JoinTableInformation task : joinTable) {
//            Decomenteaza daca vrei sa stearga what objective de la userii care nu au how objective
//            List<HowInformation> howList = howRepository.findAllByWhatIdAndUserId(task.getWhatId(), task.getUserId());
//            if(!howList.isEmpty())
                whatTasks.add(whatRepository.findWhatInformationByTaskId(task.getWhatId()));
        }
        return whatTasks;
    }
    public void deleteTask(Long taskId){
        boolean exists = whatRepository.existsById(taskId);
        if (!exists) {
            throw new IllegalStateException("taskul cu id-ul" + taskId + " nu exista");
        }
        System.out.println("intra in service");
        whatRepository.deleteById(taskId);
    }

    public void deleteTaskFromUser(Long userId, Long taskId){
        JoinTableInformation task = joinTableRepository.findJoinTableInformationByWhatIdAndUserId( taskId, userId);
        joinTableRepository.delete(task);
        List<HowInformation> deleteHow = howRepository.findAllByWhatIdAndUserId(taskId, userId);
        if(deleteHow != null) {
            howRepository.deleteAll(deleteHow);
        }
    }
}
