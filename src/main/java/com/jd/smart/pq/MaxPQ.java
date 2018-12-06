/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.pq;

/**
 * <b>描述：基于堆的优先队列</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-12-06<br/>
 *
 */
public class MaxPQ<T extends Comparable<T>> extends AbstractPQ<T> implements PQ<T> {


    public MaxPQ(int maxN) {
        pq = (T[]) new Comparable[maxN];
    }

    @Override
    public void insert(T key) {
        pq[++N] = key;
        swim(N);
    }

    @Override
    public T delMax() {
        T max = pq[1];
        exchange(1, N--);
        sink(1);
        return max;
    }
}