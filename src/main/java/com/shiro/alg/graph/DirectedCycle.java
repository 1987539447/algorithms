/*
 */
package com.shiro.alg.graph;

import java.util.Stack;

/**
 * <b>描述：有向图检测环</b> <br/>
 * @date <b>时间：</b>2019-05-05<br/>
 *
 */
public class DirectedCycle {

    private boolean[] marked;

    private int[] edgeTo;

    private Stack<Integer> cycle;

    private boolean[] onStack;

    public DirectedCycle(Digraph digraph) {
        this.marked = new boolean[digraph.V()];
        this.edgeTo = new int[digraph.V()];
        this.onStack = new boolean[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (Integer w : digraph.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            } else if (onStack[w]) {
                this.cycle = new Stack<>();
                for (int x = v; x != w ; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return this.cycle != null;
    }

    public Iterable<Integer> cycle() {
        return this.cycle;
    }

}