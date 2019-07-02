/*

 */
package com.shiro.alg.graph;

/**
 * <b>描述：kosaraju算法计算强连通分量</b> <br/>
 * @date <b>时间：</b>2019-05-13<br/>
 *
 */
public class KosarajuSCC {
    //根据图G的反向图G-R的逆后序的顺序来遍历搜索图G，并标记连通分量

    private boolean[] marked;//已访问顶点标记
    private int[] id;//强连通分量标识
    private int count;//强连通分量数量

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for (Integer s : order.reversePost()) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean stronglyConnected(int w, int v) {
        return id[w] == id[v];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}