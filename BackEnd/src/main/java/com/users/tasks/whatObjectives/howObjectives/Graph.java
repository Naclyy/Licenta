package com.users.tasks.whatObjectives.howObjectives;

public class Graph {
    private String name;
    private int estimatedTime;
    private int earlyStart;
    private int earlyFinish;
    private int lateStart;
    private int lateFinish;

    public Graph(String name, int earlyStart, int earlyFinish, int lateStart, int lateFinish) {
        this.name = name;
        this.earlyStart = earlyStart;
        this.earlyFinish = earlyFinish;
        this.lateStart = lateStart;
        this.lateFinish = lateFinish;
    }

    public String getName() {
        return name;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public int getEarlyStart() {
        return earlyStart;
    }

    public int getEarlyFinish() {
        return earlyFinish;
    }

    public int getLateStart() {
        return lateStart;
    }

    public int getLateFinish() {
        return lateFinish;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "name='" + name + '\'' +
                ", estimatedTime=" + estimatedTime +
                ", earlyStart=" + earlyStart +
                ", earlyFinish=" + earlyFinish +
                ", lateStart=" + lateStart +
                ", lateFinish=" + lateFinish +
                '}';
    }
}
