package com.dao;

import com.entities.HowInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HowRepository extends JpaRepository<HowInformation, Long> {
    List<HowInformation> findHowInformationByUserId(Long id);
    List<HowInformation> findHowInformationByWhatId(Long id);
    Optional<HowInformation> removeHowInformationsByUserId(Long id);
    List<HowInformation> findAllByWhatId(Long id);
    HowInformation findTopByOrderByTaskIdDesc();
    List<HowInformation> findAllByWhatIdAndUserId(Long whatId, Long userID);
}
