/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：加权有向边</b> <br/>
 * @date <b>时间：</b>2019-08-20<br/>
 *
 */
public class DirectedEdge {

    private final int v;

    private final int w;

    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}