
package com.shiro.alg.pq;

/**
 * <b>描述：索引优先队列</b> <br/>
 *
 * <b>时间：</b>2018-12-06<br/>
 *
 */
public interface IndexPQ<T extends Comparable<T>> {
    void insert(int k, T t);
    void changeKey(int k, T t);
    boolean contains(int k);
    void delete(int k);
    T minKey();
    int minIndex();
    int delMin();
    boolean isEmpty();
    int size();
}