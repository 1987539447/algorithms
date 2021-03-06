
package com.shiro.alg.pq;

import java.util.NoSuchElementException;

/**
 * <b>描述：索引优先队列实现</b> <br/>
 *
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
        pq[n] = k;
        qp[k] = n;
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
        int index = qp[k];
        exchange(index, n--);
        swim(index);
        sink(index);
        keys[k] = null;
        qp[k] = -1;
    }

    @Override
    public T minKey() {
        return keys[pq[1]];
    }

    @Override
    public int minIndex() {
        return pq[1];
    }

    @Override
    public int delMin() {
        int min = pq[1];
        exchange(1, n--);
        sink(1);
        qp[min] = -1;
        keys[min] = null;
        pq[n+1] = -1;
        return min;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
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