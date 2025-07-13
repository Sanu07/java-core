package com.graph;

public class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }


    @Override
    public int compareTo(Edge o) {
        return this.wt - o.wt;
    }
}
