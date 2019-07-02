/*

 */
package com.shiro.alg.graph;

/**
 * <b>描述：强连通分量API</b> <br/>
 * @date <b>时间：</b>2019-07-02<br/>
 *
 */
public interface SCC {

    //v 和 w是否强连通
    boolean stronglyConnected(int v, int w);

    //图中强连通分量数量
    int count();

    //顶点v所在的强连通分量ID
    int id(int v);
}