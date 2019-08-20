/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：加权边</b> <br/>
 * @date <b>时间：</b>2019-08-13<br/>
 *
 */
public class Edge implements Comparable<Edge>{

    private final int v;

    private final int w;

    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return this.weight;
    }

    public int either() {
        return this.v;
    }

    public int other(int vertex) {
        if (this.v == vertex) {
            return this.w;
        } else if (this.w == vertex) {
            return this.w;
        } else {
            throw new IllegalArgumentException("error edge");
        }
    }

    @Override
    public int compareTo(Edge other) {
        if (this.weight > other.weight()) {
            return 1;
        }
        if (this.weight < other.weight) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}