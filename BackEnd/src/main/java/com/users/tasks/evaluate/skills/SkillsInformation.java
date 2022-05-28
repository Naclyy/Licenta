package com.users.tasks.evaluate.skills;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "skills")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class SkillsInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long skillId;
    private String skills;

    public SkillsInformation(String skills) {
        this.skills = skills;
    }
}
