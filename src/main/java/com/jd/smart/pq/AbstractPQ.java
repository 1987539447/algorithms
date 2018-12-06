/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.pq;

/**
 * <b>描述：优先队列抽象实现</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-12-06<br/>
 *
 */
public abstract class AbstractPQ<T extends Comparable<T>>{

    protected T[] pq;
    protected int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return  N;
    }

    protected void swim(int k) {

        while (k>1 && less(k/2, k)) {
             exchange(k/2, k);
             k = k/2;
        }
    }

    protected void sink(int k) {

        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)){
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    protected boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    protected void exchange(int i, int j) {
        T tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
}