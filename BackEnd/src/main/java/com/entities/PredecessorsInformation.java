package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.entities.HowInformation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "predecessors")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class PredecessorsInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) // se aplica doar la id
    private Long id;
    @Column(name = "how_id")
    private Long howId;
    private Long predecessorId;
    @JsonIgnore
    @ManyToOne(targetEntity = HowInformation.class, optional = false)
    @JoinColumn(name = "how_id", updatable = false, insertable = false)
    private HowInformation predecessors;

    public PredecessorsInformation(Long howId, Long predecessorId) {
        this.howId = howId;
        this.predecessorId = predecessorId;
    }
}
