package com.users.tasks.whatObjectives;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.users.UserInformation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "what_task")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class WhatInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long taskId;
    @Column(name = "user_id")
    private Long userId;
    private String objective;
    private String dateAdded;
    private String deadline;
    @JsonIgnore
    @ManyToOne(targetEntity = com.users.UserInformation.class, optional = false)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private UserInformation userWhatTasks;

    public WhatInformation(Long userId, String objective, String dateAdded, String deadline) {
        this.userId = userId;
        this.objective = objective;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
    }
}
