/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.Bag;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>描述：BellmanFord算法 检测含负权重边最短路径</b> <br/>
 * @date <b>时间：</b>2019-09-03<br/>
 *
 */
public class BellmanFordSP {

    //到顶点i的最短距离
    private double[] distTo;
    //到达顶点i的边
    private DirectedEdge[] edgeTo;
    //标识顶点是否已经在队列
    private boolean[] onQueue;
    //待放松顶点队列
    private Queue<Integer> queue;
    //
    private int cost;

    private Iterable<DirectedEdge> cycle;

    public BellmanFordSP(EdgeWeightedDigraph digraph, int s) {
        distTo = new double[digraph.V()];
        edgeTo = new DirectedEdge[digraph.V()];
        onQueue = new boolean[digraph.V()];
        queue = new LinkedList<>();

        for (int v = 0; v < digraph.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;
        onQueue[s] = true;
        queue.add(s);
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            Integer v = queue.poll();
            onQueue[v] = false;
            relax(digraph, v);
        }
    }

    private void relax(EdgeWeightedDigraph digraph, Integer v) {
        for (DirectedEdge edge : digraph.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight()) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (!onQueue[w]) {
                    queue.add(w);
                    onQueue[w] = true;
                }
            }
            //放松次数达到顶点数时，检测是否有负权重环
            if (cost++ % digraph.V() == 0) {
                findNegativeCycle();
            }
        }
    }

    //负权重环检测：根据现在的边情况构建图，检测是否有环
    private void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for (DirectedEdge edge : edgeTo) {
            if (edge != null) {
                spt.addEdge(edge);
            }
        }
        EdgeWeightedCycleFinder finder = new EdgeWeightedCycleFinder(spt);
        cycle = finder.cycle();

    }

    public boolean hasNegativeCycle() {
        return this.cycle != null;
    }

    //返回负权重环
    public Iterable<DirectedEdge> negativeCycle() {
       return this.cycle;
    }
}