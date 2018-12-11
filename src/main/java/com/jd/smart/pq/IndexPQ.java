/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.pq;

/**
 * <b>描述：索引优先队列</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
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