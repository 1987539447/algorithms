/*
 */
package com.shiro.alg.search;

/**
 * <b>描述：线性探测法hash表</b> <br/>
 * @date <b>时间：</b>2019-03-14<br/>
 *
 */
public class LinearProbingHahsST<K, V> {

    private int size;
    private int M = 16;

    private K[] keys;
    private V[] values;

    public LinearProbingHahsST() {
        this(16);
    }

    public LinearProbingHahsST(int capacity) {
        this.M = capacity;
        keys =  (K[])new Object[capacity];
        values = (V[]) new Object[capacity];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
        if (size >= M/2) {
            resize(2*M);
        }
        int index;
        for (index = hash(key); keys[index] != null; index = (index + 1) % M) {
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        size++;

    }

    public V get(K key) {
        for (int i = hash(key); keys[i] != null ; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    private void resize(int capacity) {
        LinearProbingHahsST<K, V> newST = new LinearProbingHahsST<>(capacity);
        for (int i = 0; i < size; i++) {
            if (keys[i] != null) {
                newST.put(keys[i], values[i]);
            }
        }
        keys = newST.keys;
        values = newST.values;
        size = newST.size;
    }

    public void delete(K key) {
        if (!contains(key)) {
            return;
        }
        int index = hash(key);
        while (!keys[index].equals(key)) {
            index = (index + 1) % M;
        }
        keys[index] = null;
        values[index] = null;

        index = (index + 1) % M;
        while (keys[index] != null) {
            K keyToMv = keys[index];
            V valToMv = values[index];
            keys[index] = null;
            values[index] = null;
            size--;
            put(keyToMv, valToMv);
            index = (index + 1) % M;
        }
        size--;
        if (size > 0 && size == M/8) {
            resize(M/2);
        }
    }

    public boolean contains(K key) {
        int flag = hash(key);
        if (keys[flag].equals(key)) {
            return true;
        }
        for (int index = flag + 1; keys[index] != null && index != flag ; index = (index + 1) % size) {
            if (keys[index].equals(key)) {
                return true;
            }
        }
        return false;
    }
}