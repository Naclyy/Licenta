package com.users.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskInformation, Long> {
    Optional<TaskInformation> findTaskInformationByUserId(Long id);
}
