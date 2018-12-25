
package com.shiro.alg.search;

import com.shiro.alg.BinarySearch;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <b>描述：有序数组实现</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-12-24<br/>
 *
 */
public class BinarySearchST<K extends Comparable<K>,V> extends AbstractST<K , V> implements ST<K,V> {

    private static final int INIT_CAPACITY = 8;
    private int size;
    private K[] keys;
    private V[] values;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity) {
        keys = (K[]) new Comparable[capacity];
        values = (V[]) new Object[capacity];
    }

    @Override
    public void put(K key, V value) {
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return;
        }
        //移动插入
        for (int j = size; j < i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
    }

    @Override
    public V get(K key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            return values[i];
        }
        return null;
    }

    @Override
    public void delete(K key) {
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            for (int j = i; j < size - 1; j++) {
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
            size--;
            keys[size] = null;
            values[size] = null;

        }
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public K min() {
        if (isEmpty()) {
            return null;
        }
        return keys[0];
    }

    @Override
    public K max() {
        if (isEmpty()) {
            return null;
        }
        return keys[size-1];
    }

    @Override
    public K floor(K key) {
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            return key;
        }
        if (i == 0) {
            return null;
        }
        return keys[i-1];
    }

    @Override
    public K ceiling(K key) {
        return null;
    }

    @Override
    public int rank(K key) {
        int lo = 0, hi = size-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid -1;
            } else if(cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public int rank(K key, int lo, int hi) {
        if (hi < lo) {
            return lo;
        }
        int mid = lo + (hi - lo)/2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key,lo, mid-1);
        } else if (cmp > 0) {
            return rank(key, mid+1, hi);
        } else {
            return mid;
        }
    }

    @Override
    public K select(int k) {
        return keys[k];
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {
        List<K> result = new ArrayList<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            result.add(keys[i]);
        }
        if (contains(hi)) {
            result.add(hi);
        }
        return result;
    }
}