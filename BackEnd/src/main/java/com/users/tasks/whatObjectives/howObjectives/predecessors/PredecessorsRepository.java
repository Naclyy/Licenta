package com.users.tasks.whatObjectives.howObjectives.predecessors;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PredecessorsRepository extends JpaRepository<PredecessorsInformation, Long> {
    List<PredecessorsInformation> findAllByHowId(Long id);
    PredecessorsInformation findPredecessorsInformationByPredecessorId(Long id);
}
