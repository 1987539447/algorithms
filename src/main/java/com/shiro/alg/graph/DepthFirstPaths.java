/*
 */
package com.shiro.alg.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <b>描述：深度优先搜素路径</b> <br/>
 * @date <b>时间：</b>2019-03-19<br/>
 *
 */
public class DepthFirstPaths implements Paths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s ; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < path.size() + 1; i++) {
            result.add(path.pop());
        }
        return result;
    }
}