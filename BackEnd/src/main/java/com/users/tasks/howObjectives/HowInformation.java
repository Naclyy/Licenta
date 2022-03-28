package com.users.tasks.howObjectives;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.users.UserInformation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
    @Column(name = "user_id")
    private Long userId;
    private String objectives;
    private String dateAdded;
    private String deadline;
    @JsonIgnore
    @ManyToOne(targetEntity = com.users.UserInformation.class, optional = false)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private UserInformation userHowTasks;


    public HowInformation(Long userId, String objectives, String dateAdded, String deadline) {
        this.userId = userId;
        this.objectives = objectives;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
    }


}
