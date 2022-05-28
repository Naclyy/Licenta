package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.entities.UserInformation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "evaluate")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class EvaluateInformation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) // se aplica doar la id
    private Long evaluateId;
    @Column(name = "user_id")
    private Long userId;
    private Long keyStrength1Id;
    private Long keyStrength2Id;
    private Long keyStrength3Id;
    private String ksComment;
    private Long skillOpportunityId;
    private String soComment;
    private Long skillPriority1Id;
    private Long skillPriority2Id;
    private Long skillPriority3Id;
    private String spComment;

    @JsonIgnore
    @OneToOne(targetEntity = UserInformation.class, optional = false)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private UserInformation userEvaluate;


    public EvaluateInformation(Long userId, Long keyStrength1Id, Long keyStrength2Id, Long keyStrength3Id, String ksComment, Long skillOpportunityId, String soComment, Long skillPriority1Id, Long skillPriority2Id, Long skillPriority3Id, String spComment) {
        this.userId = userId;
        this.keyStrength1Id = keyStrength1Id;
        this.keyStrength2Id = keyStrength2Id;
        this.keyStrength3Id = keyStrength3Id;
        this.ksComment = ksComment;
        this.skillOpportunityId = skillOpportunityId;
        this.soComment = soComment;
        this.skillPriority1Id = skillPriority1Id;
        this.skillPriority2Id = skillPriority2Id;
        this.skillPriority3Id = skillPriority3Id;
        this.spComment = spComment;
    }
}