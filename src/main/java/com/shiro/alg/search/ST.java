
package com.shiro.alg.search;

/**
 * <b>描述：符号表Symbol Table模型API</b> <br/>
 * key value均不能为空，get时不存在返回空
 *
 * <b>时间：</b>2018-12-21<br/>
 *
 */
public interface ST<K extends Comparable<K>, V> {

    void put(K key, V value);
    V get(K key);
    void delete(K key);
    boolean contains(K key);
    boolean isEmpty();
    int size();
    K min();
    K max();
    /**向下取整：小于等于该键的最大键**/
    K floor(K key);
    /**向上取整：大于等于key的的最小键**/
    K ceiling(K key);
    int rank(K key);
    K select(int k);
    void deleteMin();
    void deleteMax();
    int size(K lo, K hi);
    Iterable<K> keys(K lo, K hi);
    Iterable<K> keys();
}