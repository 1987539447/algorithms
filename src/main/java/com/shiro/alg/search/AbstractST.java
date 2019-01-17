
package com.shiro.alg.search;

/**
 * <b>描述：抽象实现</b> <br/>
 *
 * <b>时间：</b>2018-12-21<br/>
 *
 */
public abstract class AbstractST<K extends Comparable<K>, V> implements ST<K,V> {

    @Override
    public void deleteMin() {
        delete(min());
    }

    @Override
    public void deleteMax() {
        delete(max());
    }

    @Override
    public int size(K lo, K hi) {
        if (hi.compareTo(lo) <0) {
            return 0;
        } else if(contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    @Override
    public Iterable<K> keys() {
        return keys(min(), max());
    }
}