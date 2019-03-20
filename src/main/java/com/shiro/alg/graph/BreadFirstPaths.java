/*
 */
package com.shiro.alg.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * <b>描述：广度优先搜索</b> <br/>
 * @date <b>时间：</b>2019-03-20<br/>
 *
 */
public class BreadFirstPaths implements Paths {

    private boolean[] marked;

    private int[] edgeTo;

    private final int s;

    public BreadFirstPaths(Graph graph, int s) {
        this.s = s;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        marked[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    queue.offer(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
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
        Deque<Integer> queue = new ArrayDeque<>();
        for (int x = v; x != s ; x = edgeTo[x]) {
            queue.offer(x);
        }
        queue.offer(s);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
           result.add(queue.pollLast());
        }
        return result;
    }
}