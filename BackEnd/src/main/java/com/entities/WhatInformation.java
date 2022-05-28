package com.entities;

import com.entities.HowInformation;
import com.entities.JoinTableInformation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "what_task")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class WhatInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "what_id",nullable = false, updatable = false)
    private Long taskId;
    private String objective;
    private String dateAdded;
    private String deadline;

    @OneToMany(mappedBy = "whatJoinTable", cascade = CascadeType.ALL)
    private List<JoinTableInformation> joinTableInformationList;

    @OneToMany(mappedBy = "whatTasks", cascade = CascadeType.ALL)
    private List<HowInformation> howInformationList;

    public WhatInformation(String objective, String dateAdded, String deadline) {
        this.objective = objective;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
    }

}
