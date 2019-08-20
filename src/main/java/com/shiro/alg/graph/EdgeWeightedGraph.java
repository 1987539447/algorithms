/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.Bag;
import com.shiro.alg.util.In;

/**
 * <b>描述：加权无向图</b> <br/>
 * @date <b>时间：</b>2019-08-13<br/>
 *
 */
public class EdgeWeightedGraph {

    private final int V;

    private int E;

    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < v; i++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(v, w, weight));
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    //返回图中所有边
    public Iterable<Edge> edges() {
        Bag<Edge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (Edge edge : adj[v]) {
                if (edge.other(v) > v) {
                    bag.add(edge);
                }
            }
        }
        return bag;
    }
}