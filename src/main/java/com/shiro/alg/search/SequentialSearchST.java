
package com.shiro.alg.search;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>描述：无序链表实现</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-12-21<br/>
 *
 */
public class SequentialSearchST<K extends Comparable<K>, V> extends AbstractST<K, V> implements ST<K, V> {

    private Node first;
    private int size;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key can not be null");
        }
        if (value == null) {
            delete(key);
            return;
        }
        for (Node tmp = first; tmp != null; tmp = tmp.next) {
            if (tmp.key.equals(key)) {
                tmp.value = value;
                size++;
                return;
            }
        }
        first = new Node(key, value, first);
        size++;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key can not be null");
        }
        for (Node pt = first; pt != null; pt = pt.next) {
            if (pt.key.equals(key)) {
                return pt.value;
            }
        }
        return null;
    }

    @Override
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key can not be null");
        }
        for (Node pre = null, pt = first; pt != null; pre = pt, pt = pt.next) {
            if (pt.key.equals(key)) {
                if (pre != null) {
                    pre.next = pt.next;
                } else {
                    first = pt.next;
                }
                pt.next = null;
                size--;
                return;
            }
        }
    }

    @Override
    public boolean contains(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key can not be null");
        }
        for (Node pt = first; pt != null; pt = pt.next) {
            if (pt.key.equals(key)) {
                return true;
            }
        }
        return false;
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
        K min = first.key;
        for (Node pt = first; pt != null; pt = pt.next) {
            if (pt.key.compareTo(min) < 0) {
                min = pt.key;
            }
        }
        return min;
    }

    @Override
    public K max() {
        K max = first.key;
        for (Node pt = first; pt != null; pt = pt.next) {
            if (pt.key.compareTo(max) > 0) {
                max = pt.key;
            }
        }
        return max;
    }

    @Override
    public K floor(K key) {
        return null;
    }

    @Override
    public K ceiling(K key) {
        return null;
    }

    @Override
    public int rank(K key) {
        return 0;
    }

    @Override
    public K select(int k) {
        return null;
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {
        List<K> result = new ArrayList<>();
        for (Node pt = first; pt != null; pt = pt.next) {
            result.add(pt.key);
        }
        return result;
    }

    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value =value;
            this.next = next;
        }

    }
}