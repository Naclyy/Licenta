package com.dao;

import com.entities.JoinTableInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoinTableRepository extends JpaRepository<JoinTableInformation, Long> {
        List<JoinTableInformation> findJoinTableInformationByUserId(Long id);
        JoinTableInformation findJoinTableInformationByWhatIdAndUserId(Long task_id, Long user_id);
}
