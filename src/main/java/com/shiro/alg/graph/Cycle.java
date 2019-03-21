/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：是否无环图</b> <br/>
 * @date <b>时间：</b>2019-03-21<br/>
 *
 */
public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph graph) {
        this.marked = new boolean[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s]) {
                dfs(graph, s, s);
            }
        }
    }

    private void dfs(Graph graph, int v, int u) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
           if (!marked[w]) {
               dfs(graph, w, u);
           } else if (w == u){
              hasCycle = true;
           }
        }
    }

    public boolean hasCycle() {
        return this.hasCycle;
    }
}