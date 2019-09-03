/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：拓扑排序 - 逆后序 有向无环</b> <br/>
 * @date <b>时间：</b>2019-05-05<br/>
 *
 */
public class Topological {

    private Iterable<Integer> order;

    public Topological(Digraph digraph) {
       DirectedCycle cycleFinder = new DirectedCycle(digraph);
       if (!cycleFinder.hasCycle()) {
           DepthFirstOrder dfs = new DepthFirstOrder(digraph);
           order = dfs.reversePost();
       }
    }

    public Topological(EdgeWeightedDigraph digraph) {

    }

    public Iterable<Integer> order() {
        return this.order;
    }

    public boolean isDAG() {
        return this.order != null;
    }
}