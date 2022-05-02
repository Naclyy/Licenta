package com.pert;

import java.util.LinkedList;
import java.util.List;

public class PertNodes {
    List<PertNodes> predecessors = new LinkedList<>();
    int id;
    String name;
    int estimatedTime;
    int earlyStart;
    int earlyFinish;
    int lateStart;
    int lateFinish;
    boolean isLast = false;
    int slack = 0;

    public int getEarlyStart() {
        return earlyStart;
    }

    public void setEarlyStart(int earlyStart) {
        this.earlyStart = earlyStart;
    }

    public int getEarlyFinish() {
        return earlyFinish;
    }

    public void setEarlyFinish(int earlyFinish) {
        this.earlyFinish = earlyFinish;
    }

    public int getLateStart() {
        return lateStart;
    }

    public void setLateStart(int lateStart) {
        this.lateStart = lateStart;
    }

    public int getLateFinish() {
        return lateFinish;
    }

    public void setLateFinish(int lateFinish) {
        this.lateFinish = lateFinish;
    }

    public PertNodes(int id, int estimatedTime, int earlyStart, int earlyFinish, int lateStart, int lateFinish) {
        this.id = id;
        this.estimatedTime = estimatedTime;
        this.earlyStart = earlyStart;
        this.earlyFinish = earlyFinish;
        this.lateStart = lateStart;
        this.lateFinish = lateFinish;
    }

    public int getId() {
        return id;
    }

    public PertNodes(int id, int estimatedTime) {
        this.id = id;
        this.estimatedTime = estimatedTime;
        this.earlyStart = 0;
        this.earlyFinish = -1;
        this.lateStart = 0;
        this.lateFinish = -1;
    }
    public void setLast(){
        this.isLast = true;
    }
    public void addPredecessors(PertNodes pred){
        this.predecessors.add(pred);
    }

    public void calculateEarlyStartFinish(){
        if(!predecessors.isEmpty()) {
            for (PertNodes node : predecessors) {
                if (this.earlyStart < node.earlyFinish) {
                    this.earlyStart = node.earlyFinish;
                }
            }
            this.earlyFinish = this.earlyStart + this.estimatedTime;
        }
        this.lateFinish = this.earlyFinish;
        this.lateStart = this.lateFinish - this.estimatedTime;
    }

    public void calculateLateStartFinish(){
        for(PertNodes node : predecessors) {
            if(this.lateStart < node.lateFinish || this.lateFinish == this.earlyFinish){
                node.lateFinish = this.lateStart;
                node.lateStart = this.lateStart - node.estimatedTime;
                node.slack = node.lateStart - node.earlyStart;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getPredecessor(){
        System.out.println(predecessors);
    }
    @Override
    public String toString() {
        return "PertNodes{" +
                "earlyStart=" + earlyStart +
                ", earlyFinish=" + earlyFinish +
                ", lateStart=" + lateStart +
                ", lateFinish=" + lateFinish +
                ", slack=" + slack +
                '}';
    }
}
