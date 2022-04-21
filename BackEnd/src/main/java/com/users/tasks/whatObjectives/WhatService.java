package com.users.tasks.whatObjectives;

import com.users.UserInformation;
import com.users.tasks.whatObjectives.howObjectives.HowInformation;
import com.users.tasks.whatObjectives.howObjectives.predecessors.PredecessorsRepository;
import com.users.tasks.whatObjectives.userWhatJoin.JoinTableInformation;
import com.users.tasks.whatObjectives.userWhatJoin.JoinTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class WhatService {
    private final WhatRepository whatRepository;
    private final JoinTableRepository joinTableRepository;
    public List<WhatInformation> getAll() {
        return whatRepository.findAll();
    }
    public WhatInformation addNewTask(WhatInformation whatInformation, Long user_id){
        WhatInformation whatTask = whatRepository.save(whatInformation);
        whatRepository.flush();
        joinTableRepository.save(new JoinTableInformation(user_id, whatTask.getTaskId()));
        return whatInformation;
    }
    public List<WhatInformation> getWhatObjectivesByUserId(Long user_id){
        List<JoinTableInformation> joinTable = joinTableRepository.findJoinTableInformationByUserId(user_id);
        List<WhatInformation> whatTasks = new LinkedList<>();
        for(JoinTableInformation task : joinTable) {
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
}
