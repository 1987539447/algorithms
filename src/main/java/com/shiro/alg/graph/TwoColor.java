/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：双色问题</b> <br/>
 * @date <b>时间：</b>2019-03-21<br/>
 *
 */
public class TwoColor {

    private boolean[] marked;

    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph graph) {
        this.marked = new boolean[graph.V()];
        this.color = new boolean[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(graph, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }
    }

    public boolean isTwoColorable() {
        return this.isTwoColorable;
    }
}