/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.uf;

/**
 * <b>描述：union find 连通性检测</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
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