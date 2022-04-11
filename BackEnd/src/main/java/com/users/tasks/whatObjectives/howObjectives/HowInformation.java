package com.users.tasks.whatObjectives.howObjectives;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.users.UserInformation;
import com.users.tasks.whatObjectives.WhatInformation;
import com.users.tasks.whatObjectives.howObjectives.predecessors.PredecessorsInformation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "how_task")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class HowInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) // se aplica doar la id
    private Long taskId;
    @Column(name = "what_id")
    private Long whatId;
    @Column(name = "user_id")
    private Long userId;
    private String objectives;
    private int estimatedTime;

    @OneToMany(mappedBy = "predecessors")
    private List<PredecessorsInformation> predecessorsInformationList;

    @JsonIgnore
    @ManyToOne(targetEntity = com.users.tasks.whatObjectives.WhatInformation.class, optional = false)
    @JoinColumn(name = "what_id", updatable = false, insertable = false)
    private WhatInformation whatTasks;

    @JsonIgnore
    @ManyToOne(targetEntity = com.users.UserInformation.class, optional = false)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private UserInformation userHowTasks;


    public HowInformation(Long whatId, Long userId, String objectives, int estimatedTime) {
        this.whatId = whatId;
        this.userId = userId;
        this.objectives = objectives;
        this.estimatedTime = estimatedTime;
    }
}