package com.dao;

import com.entities.PredecessorsInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PredecessorsRepository extends JpaRepository<PredecessorsInformation, Long> {
    List<PredecessorsInformation> findAllByHowId(Long id);
    List<PredecessorsInformation> findPredecessorsInformationByPredecessorId(Long id);
}
