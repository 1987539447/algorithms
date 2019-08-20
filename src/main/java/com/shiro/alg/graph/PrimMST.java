/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.pq.IndexMinPQ;
import java.util.Arrays;

/**
 * <b>描述：Prim即时算法</b> <br/>
 * 从0开始遍历，不断去更新临时最小生成树
 * @date <b>时间：</b>2019-08-19<br/>
 *
 */
public class PrimMST extends MST {

    //顶点v连到最小生成树的边
    private Edge[] edgeTo;
    //最小生成树边的权重
    private double[] distTo;
    //顶点是否被访问
    private boolean[] marked;
    //索引优先队列 - 顶点v到最小生成树的权重
    private IndexMinPQ<Double> pq;

    PrimMST(EdgeWeightedGraph graph) {
        super(graph);
        edgeTo = new Edge[graph.V()];
        distTo = new double[graph.V()];
        marked = new boolean[graph.V()];
        pq = new IndexMinPQ<>(graph.V());
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0.0;
        visit(graph, 0);
        while (!pq.isEmpty()) {
            visit(graph, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge edge : graph.adj(v)) {
            int w = edge.other(v);
            if (marked[w]) {
                continue;
            }

            if (edge.weight() < distTo[w]) {
                edgeTo[w] = edge;
                distTo[w] = edge.weight();
                if (pq.contains(w)) {
                    pq.changeKey(w, edge.weight());
                } else {
                    pq.insert(w, edge.weight());
                }
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return Arrays.asList(edgeTo);
    }

    @Override
    public double weight() {
        double weight = 0.0;
        for (Edge edge : edgeTo) {
            weight += edge.weight();
        }
        return weight;
    }
}