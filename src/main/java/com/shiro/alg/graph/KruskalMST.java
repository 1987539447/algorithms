/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.uf.QuickUnionPathCompressionUF;
import com.shiro.alg.uf.UF;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <b>描述：kruskal最小生成树算法：将所有边存入优先队列，并依次检测最小边顶点是否已经联通</b> <br/>
 * @date <b>时间：</b>2019-08-20<br/>
 *
 */
public class KruskalMST extends MST {

    private Queue<Edge> mst;


    KruskalMST(EdgeWeightedGraph graph) {
        super(graph);
        mst = new LinkedList<>();
        Queue<Edge> minPQ = new PriorityQueue<>(graph.E());
        for (Edge edge : graph.edges()) {
            minPQ.add(edge);
        }
        UF uf = new QuickUnionPathCompressionUF(graph.V());
        while (!minPQ.isEmpty() && mst.size() < graph.V() - 1) {
            Edge edge = minPQ.remove();
            int v = edge.either(), w = edge.other(v);
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v,w);
            mst.add(edge);
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        double weight = 0.0;
        for (Edge edge : mst) {
            weight += edge.weight();
        }
        return weight;
    }
}