
package com.shiro.alg.pq;

/**
 * <b>描述：优先队列接口</b> <br/>
 *
 * <b>时间：</b>2018-12-06<br/>
 *
 */
public interface PQ<T extends Comparable<T>> {
    boolean isEmpty();
    int size();
    void insert(T key);
    T delMax();
}