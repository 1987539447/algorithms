/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.Bag;
import com.shiro.alg.util.In;
import com.shiro.alg.util.StdOut;

/**
 * <b>描述：有向图深度优先搜索</b> <br/>
 * @date <b>时间：</b>2019-05-05<br/>
 *
 */
public class DirectDFS {

    private boolean[] marked;

    public DirectDFS(Digraph digraph, int source) {
        marked = new boolean[digraph.V()];
        dfs(digraph, source);
    }

    public DirectDFS(Digraph digraph, Iterable<Integer> sources) {
        marked = new boolean[digraph.V()];
        for (Integer source : sources) {
           if (!marked(source)) {
               dfs(digraph, source);
           }
        }
    }

    public boolean marked(Integer v) {
        return marked[v];
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (Integer w : digraph.adj(v)) {
            if (!marked(w)) {
                dfs(digraph, w);
            }
        }
    }

    public static void main(String[] args) {
        String dataFile = "";
        Bag<Integer> sources = new Bag<>();
        sources.add(2);
        In input = new In(dataFile);
        Digraph digraph = new Digraph(input);
        DirectDFS reachable = new DirectDFS(digraph, sources);
        for (int v = 0; v < digraph.V(); v++) {
            if (reachable.marked(v)) {
                StdOut.print(v +" ");
            }
            StdOut.println();
        }
    }
}