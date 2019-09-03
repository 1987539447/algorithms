/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：无环加权有向图最短路径-线性算法</b> <br/>
 * 按照图的拓扑排序来依次放松顶点
 * @date <b>时间：</b>2019-08-27<br/>
 *
 */
public class AcyclicSP extends SP {

    public AcyclicSP(EdgeWeightedDigraph digraph, int s) {
        edgeTo = new DirectedEdge[digraph.V()];
        distTo = new double[digraph.V()];
        for (int i = 0; i < digraph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0.0;

        Topological topological = new Topological(digraph);
        for (Integer v : topological.order()) {
            relax(digraph, v);
        }
    }

    private void relax(EdgeWeightedDigraph digraph, int v) {
        for (DirectedEdge edge : digraph.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight()) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
            }
        }
    }
}