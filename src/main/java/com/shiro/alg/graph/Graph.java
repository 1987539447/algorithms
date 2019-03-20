/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.Bag;
import com.shiro.alg.util.In;

/**
 * <b>描述：邻接表实现图</b> <br/>
 * @date <b>时间：</b>2019-03-18<br/>
 *
 */
public class Graph {

    private final int V;

    private int E;

    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt(); //不需要赋值给E，增加边时会累加边总数
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int degree(Graph graph, int v) {
        return adj[v].size();
    }

    public static int maxDegree(Graph graph) {
        int max = 0;
        for (int v = 0; v < graph.V(); v++) {
            if (graph.degree(graph, v) > max) {
                max = v;
            }
        }
        return max;
    }

    public static double avgDegree(Graph graph) {
        return 2 * graph.E() / graph.V();
    }

    public static int numberOfSelfLoop(Graph graph) {
        int loop = 0;
        for (int v = 0; v < graph.V(); v++) {
            for (int w : graph.adj(v)) {
                if (w == v) {
                    loop++;
                }
            }
        }
        return loop/2;
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(V).append(" vertices, ")
                .append(E).append(" edges\n");
        for (int v = 0; v < V; v++) {
            buf.append(v).append(": ");
            for (int w : adj(v)) {
                buf.append(w).append(" ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }
}