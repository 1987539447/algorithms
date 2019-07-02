/*

 */
package com.shiro.alg.graph;

/**
 * <b>描述：深度优先搜索的顶点可达分析</b> <br/>
 * @date <b>时间：</b>2019-07-02<br/>
 *
 */
public class DFSTransitiveClosure implements TransitiveClosure{

    //保存从所有顶点开始的搜索记录
    private DirectDFS[] all;

    DFSTransitiveClosure(Digraph G) {
        all = new DirectDFS[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DirectDFS(G, v);
        }
    }

    @Override
    public boolean reachable(int v, int w) {
        return all[v].marked(w);
    }
}