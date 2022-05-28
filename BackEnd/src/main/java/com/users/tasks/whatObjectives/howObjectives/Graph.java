package com.users.tasks.whatObjectives.howObjectives;

public class Graph {
    private final String name;
    private final int earlyStart;
    private final int earlyFinish;
    private final int lateStart;
    private final int lateFinish;
    private final int slack;

    public Graph(String name, int earlyStart, int earlyFinish, int lateStart, int lateFinish) {
        this.name = name;
        this.earlyStart = earlyStart;
        this.earlyFinish = earlyFinish;
        this.lateStart = lateStart;
        this.lateFinish = lateFinish;
        this.slack = 0;
    }

    public String getName() {
        return name;
    }

    public int getSlack() {
        return slack;
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
                ", earlyStart=" + earlyStart +
                ", earlyFinish=" + earlyFinish +
                ", lateStart=" + lateStart +
                ", lateFinish=" + lateFinish +
                '}';
    }
}
