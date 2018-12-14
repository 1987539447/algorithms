
package com.shiro.alg.uf;

/**
 * <b>描述：连通性检测quick find算法，find为常量，union则要访问整个数组</b> <br/>
 *
 * <b>时间：</b>2018-11-07<br/>
 *
 */
public class QuickFindUF extends AbstractUF {

    //初始化触点：N个连通分量，相互都不连通
    public QuickFindUF(int n) {
        super(n);
    }

    //找到触点p所在的连通分量:数组中触点索引对应的值存储分量ID
    @Override
    public int find(int p) {
        return id[p];
    }


    //在p q建立连接：若不在同一个分量，则修改为同一个分量
    @Override
    public void union(int p, int q) {
        int pID = id[p];
        int qID = id[q];
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
                count--;
            }
        }
    }


}