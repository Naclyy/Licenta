package com.pert;

import java.util.LinkedList;
import java.util.List;

public class PertNodes {
    List<PertNodes> predecessors = new LinkedList<>();
    int estimatedTime;
    int earlyStart;
    int earlyFinish;
    int lateStart;
    int lateFinish;
    boolean isLast = false;
    int slack = 0;

    public PertNodes(int estimatedTime, int earlyStart, int earlyFinish, int lateStart, int lateFinish) {
        this.estimatedTime = estimatedTime;
        this.earlyStart = earlyStart;
        this.earlyFinish = earlyFinish;
        this.lateStart = lateStart;
        this.lateFinish = lateFinish;
    }


    public PertNodes(int estimatedTime) {
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
        if(this.isLast){
            this.lateFinish = this.earlyStart;
            this.lateStart = this.lateFinish - this.estimatedTime;
        }
    }
    public void calculateLateStartFinish(){
        for(PertNodes node : predecessors) {
            if(this.lateStart < node.lateFinish || node.lateFinish == -1){
                node.lateFinish = this.lateStart;
                node.lateStart = this.lateStart - node.estimatedTime;
                node.slack = node.lateStart - node.earlyStart;
            }
        }
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
