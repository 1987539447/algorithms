/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.pq.IndexMinPQ;

/**
 * <b>描述：Dijikstra算法最短路径</b> <br/>
 * @date <b>时间：</b>2019-08-22<br/>
 *
 */
public class DijkstraSP extends SP {

    //索引优先队列：暂存要松弛的顶点
    private IndexMinPQ<Double> pq;

    //从指定原点开始松弛，并将指向的顶点加入索引优先队列
    DijkstraSP(EdgeWeightedDigraph graph, int s) {
        edgeTo = new DirectedEdge[graph.V()];
        distTo = new double[graph.V()];
        pq = new IndexMinPQ<>(graph.V());
        for (int v = 0; v < graph.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(graph, pq.delMin());
        }
    }

    //relax 松弛：距离变短 则橡皮筋变松
    //对于边e:v->w， 如果现在到w的最短距离dist[w]大于先到v再经e到w距离(dist[v] + e.weight)长，则可以松弛w
    private void relax(EdgeWeightedDigraph graph, int v) {
        for (DirectedEdge edge : graph.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight()) {
                edgeTo[w] = edge;
                distTo[w] = distTo[v] + edge.weight();
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }
}