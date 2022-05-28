package com.entities.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddHowTask {
    private String objective;
    private int estimated_days;

    public String getObjectives() {
        return objective;
    }

    public int getEstimatedTime() {
        return estimated_days;
    }
}
