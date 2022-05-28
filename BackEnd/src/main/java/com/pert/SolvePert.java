package com.pert;

import java.util.LinkedList;
import java.util.List;

public class SolvePert {


    public void solve() {
        List<PertNodes> nodes = new LinkedList<>();
        PertNodes start = new PertNodes(1, 0, 0, 0, 0, 0);
        PertNodes A = new PertNodes(1,7);
        PertNodes B = new PertNodes(1,9);
        PertNodes C = new PertNodes(1,12);
        PertNodes D = new PertNodes(1,8);
        PertNodes E = new PertNodes(1,9);
        PertNodes F = new PertNodes(1,6);
        PertNodes G = new PertNodes(1,5);

        A.addPredecessors(start);
        B.addPredecessors(start);
        C.addPredecessors(A);

        E.addPredecessors(D);
        F.addPredecessors(C);
        F.addPredecessors(E);
        G.addPredecessors(E);

        nodes.add(start);
        nodes.add(A);
        nodes.add(B);
        nodes.add(C);

        nodes.add(E);
        nodes.add(F);
        nodes.add(G);

        for(PertNodes node : nodes){
            node.calculateEarlyStartFinish();
        }
        for(int i = nodes.size() - 1; i >= 0 ; i--){
            nodes.get(i).calculateLateStartFinish();
        }
        for(PertNodes node : nodes){
            System.out.println(node.toString());
        }
    }
}
