/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：深度优先搜索</b> <br/>
 * @date <b>时间：</b>2019-03-19<br/>
 *
 */
public class DepthFirstSearch implements Search {

    private boolean[] marked;

    private int count;

    public DepthFirstSearch(Graph graph, int s) {
       marked = new boolean[graph.V()];
       dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        count++;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    @Override
    public boolean marked(int w) {
        return marked[w];
    }

    @Override
    public int count() {
        return count;
    }


}