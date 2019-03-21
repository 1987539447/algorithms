/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：深度优先连通分量</b> <br/>
 * @date <b>时间：</b>2019-03-21<br/>
 *
 */
public class DFC implements CC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public DFC(Graph graph) {

        this.marked = new boolean[graph.V()];
        this.id = new int[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }

    }

    private void dfs(Graph graph, int v) {
        id[v] = count;
        marked[v] = true;
        for (int w : graph.adj(v)) {
           if (!marked[w]) {
               dfs(graph, w);
           }
        }
    }

    @Override
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int id(int v) {
        return id[v];
    }
}