package com.users.tasks.whatObjectives.userWhatJoin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.users.UserInformation;
import com.users.tasks.whatObjectives.WhatInformation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_what")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class JoinTableInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) // se aplica doar la id
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "what_id")
    private Long whatId;

    @JsonIgnore
    @ManyToOne(targetEntity = WhatInformation.class, optional = false)
    @JoinColumn(name = "what_id", updatable = false, insertable = false)
    private WhatInformation whatJoinTable;

    @JsonIgnore
    @ManyToOne(targetEntity = UserInformation.class, optional = false)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private UserInformation userJoinTable;

    public JoinTableInformation(Long userId, Long whatId) {
        this.userId = userId;
        this.whatId = whatId;
    }
}
