/*
 */
package com.shiro.alg.graph;

import java.util.Stack;

/**
 * <b>描述：最短路径API</b> <br/>
 * @date <b>时间：</b>2019-08-22<br/>
 *
 */
public abstract class SP {

    //从s到任意点v最短路径所经过的边
    protected DirectedEdge[] edgeTo;
    //从s到v的最短距离
    protected double[] distTo;

    //指定顶点s到v的最短路径距离
    public double distTo(int v){
        return distTo[v];
    }

    //指定顶点s是否可到达v
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    //指定顶点s到v的最短路径
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) {
            path.push(edge);
        }
        return path;
    }
}