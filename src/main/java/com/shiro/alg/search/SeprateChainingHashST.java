/*
 */
package com.shiro.alg.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <b>描述：拉链法hash表</b> <br/>
 * @date <b>时间：</b>2019-03-14<br/>
 *
 */
public class SeprateChainingHashST<K extends Comparable<K>, V> {

    private int size;
    private int M;

    private SequentialSearchST<K, V>[] st;

    public SeprateChainingHashST() {
        this(997);
    }

    public SeprateChainingHashST(int capacity) {
        this.M = capacity;
        st = (SequentialSearchST<K, V>[]) new SequentialSearchST[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }


    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
        st[hash(key)].put(key, value);
        size++;
    }

    public V get(K key) {
        return st[hash(key)].get(key);
    }

    public Iterable<K> keys() {
        List<K> keys = new ArrayList<>();
        for (int i = 0; i < st.length; i++) {
            keys.addAll((Collection<? extends K>) st[i].keys());
        }
        return keys;
    }

}