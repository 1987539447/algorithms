
package com.shiro.alg.pq;

/**
 * <b>描述：优先队列抽象实现</b> <br/>
 *
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