
package com.shiro.alg.pq;

/**
 * <b>描述：基于堆的优先队列</b> <br/>
 *
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