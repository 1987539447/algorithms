/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.uf;

/**
 * <b>描述：连通性检测quick find算法，find为常量，union则要访问整个数组</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
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