/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.uf;

/**
 * <b>描述：连通性检测：quick union算法，union操作为常量，find操作需要循环一条链</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-07<br/>
 *
 */
@SuppressWarnings("all")
public class QuickUnionUF extends AbstractUF {

    //初始化触点：N个连通分量，相互都不连通
    public QuickUnionUF(int n) {
        super(n);
    }

    //找到p所在分量：触点索引数组值存储相同分量中下一个分量，如果为自身则为根
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    //在p q建立连接：p q如果不连通，则将其中一个分量根节点连接到另外一个
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;

    }


}