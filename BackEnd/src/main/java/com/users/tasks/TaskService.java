package com.users.tasks;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TaskService{
    private final TaskRepository taskRepository;

    public TaskInformation addNewTask(TaskInformation taskInformation){
        taskRepository.save(taskInformation);
        return taskInformation;
    }
}
