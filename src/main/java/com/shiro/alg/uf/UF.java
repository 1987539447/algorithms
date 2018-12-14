
package com.shiro.alg.uf;

/**
 * <b>描述：union find 连通性检测</b> <br/>
 *
 * <b>时间：</b>2018-11-09<br/>
 *
 */
public interface UF {

    //返回总分量数
    int count();

    //p q两个触点是否连通
    boolean connected(int p, int q);

    //找到触点p所在的分量
    int find(int p);

    //连通触点p q
    void union(int p, int q);
}