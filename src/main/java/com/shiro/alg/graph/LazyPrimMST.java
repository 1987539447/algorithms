/*
 */
package com.shiro.alg.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <b>描述：Prim算法延时实现</b> <br/>
 *  从0开始遍历逐步添加所有的边，并跳过无效边，选取最小边
 * @date <b>时间：</b>2019-08-19<br/>
 *
 */
public class LazyPrimMST extends MST {

    //标识访问过的顶点
    private boolean[] marked;
    //最小生成树 - 普通队列
    private Queue<Edge> mst;
    //优先级队列 - 临时存储可能的横切边
    private PriorityQueue<Edge> pq;

    LazyPrimMST(EdgeWeightedGraph graph) {
        super(graph);
        marked = new boolean[graph.V()];
        mst = new LinkedList<>();
        pq = new PriorityQueue<>(graph.E());

        visit(graph, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.add(e);
            if (!marked[v]) {
                visit(graph, v);
            }
            if (!marked[w]) {
                visit(graph, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge edge : graph.adj(v)) {
            if (!marked[edge.other(v)]) {
                pq.add(edge);
            }
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