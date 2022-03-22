package com.users.tasks;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.users.UserInformation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "task")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class TaskInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) // se aplica doar la id
    private Long taskId;
    @Column(name = "user_id")
    private Long userId;
    private String whatObjectives;
    private String howObjectives;
    @JsonIgnore
    @ManyToOne(targetEntity = com.users.UserInformation.class, optional = false)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private UserInformation userInformationM20;


    public TaskInformation(Long userId, String whatObjectives, String howObjectives) {
        this.userId = userId;
        this.howObjectives = howObjectives;
        this.whatObjectives = whatObjectives;
    }


}
