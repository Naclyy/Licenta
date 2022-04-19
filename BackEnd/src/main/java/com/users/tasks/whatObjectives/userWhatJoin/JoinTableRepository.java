package com.users.tasks.whatObjectives.userWhatJoin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoinTableRepository extends JpaRepository<JoinTableInformation, Long> {
        List<JoinTableInformation> findJoinTableInformationByUserId(Long id);
}
