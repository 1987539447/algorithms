/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：联通分量API定义</b> <br/>
 * @date <b>时间：</b>2019-03-21<br/>
 *
 */
public interface CC {

    /**顶点v和w是否连通**/
    boolean connected(int v, int w);

    /**连通分量总数**/
    int count();

    /**顶点v所在的分量**/
    int id(int v);
}