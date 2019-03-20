/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：关于图的搜索处理算法API</b> <br/>
 * @date <b>时间：</b>2019-03-18<br/>
 *
 */
public interface Search {

    boolean marked(int v);
    int count();
}