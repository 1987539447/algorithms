/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.pq;

import java.util.NoSuchElementException;

/**
 * <b>描述：索引优先队列实现</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-12-06<br/>
 *
 */
public class IndexMinPQ<T extends Comparable<T>>  implements IndexPQ<T> {
    
    int maxN;
    int n;
    int[] pq;
    int[] qp;
    T[] keys;
    
    public IndexMinPQ(int maxN) {
        this.maxN = maxN;
        n = 0;
        pq = new int[maxN];
        qp = new int[maxN];
        keys = (T[]) new Comparable[maxN];
        for (int i = 0; i < maxN; i++) {
            qp[i] = -1;
        }
    }

    @Override
    public void insert(int k, T t) {
        n++;
        keys[k] = t;
        qp[k] = n;
        pq[n] = k;
        swim(n);
    }



    @Override
    public void changeKey(int k, T t) {
        if (!contains(k)) {
            throw new NoSuchElementException("not exists");
        }
        keys[k] = t;
        swim(qp[k]);
        sink(qp[k]);
    }

    @Override
    public boolean contains(int k) {
        return qp[k] != -1;
    }

    @Override
    public void delete(int k) {

    }

    @Override
    public T min() {
        return null;
    }

    @Override
    public int minIndex() {
        return 0;
    }

    @Override
    public int delMin() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    private void exchange(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[i] = j;
        qp[j] = i;
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void swim(int k) {
        while (k>1 && greater(k/2, k)) {
            exchange(k/2, k);
        }
    }

    private void sink(int k) {

    }
}