package com.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "key_strengths")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class KeyStrengthsInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long keyId;
    private String keyStrengths;

    public KeyStrengthsInformation(String keyStrengths) {
        this.keyStrengths = keyStrengths;
    }
}
