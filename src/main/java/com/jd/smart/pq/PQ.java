/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.pq;

/**
 * <b>描述：优先队列接口</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-12-06<br/>
 *
 */
public interface PQ<T extends Comparable<T>> {
    boolean isEmpty();
    int size();
    void insert(T key);
    T delMax();
}