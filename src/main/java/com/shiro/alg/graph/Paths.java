/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：路径Paths API</b> <br/>
 * @date <b>时间：</b>2019-03-19<br/>
 *
 */
public interface Paths {

    boolean hasPathTo(int v);

    Iterable<Integer> pathTo(int v);

}