/*

 */
package com.shiro.alg.graph;

/**
 * <b>描述：顶点可达性API</b> <br/>
 * @date <b>时间：</b>2019-07-02<br/>
 *
 */
public interface TransitiveClosure {

    //从v是否可达w
    boolean reachable(int v, int w);
}