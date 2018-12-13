/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.pq;

import com.jd.smart.sort.AbstractSort;
import com.jd.smart.sort.Sort;

/**
 * <b>描述：堆排序算法</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-12-11<br/>
 *
 */
public class HeapSort extends AbstractSort implements Sort {


    //从数组的中间开始，自右向左构建堆
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N/2; k >=1 ; k--) {
            sink(a, k, N);
        }
        while (N>1) {
            exchange(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private void sink(Comparable[] a, int k, int N) {

        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(a, j, j+1)){
                j++;
            }
            if (!less(a, k, j)) {
                break;
            }
            exchange(a, k, j);
            k = j;
        }
    }

    private boolean less(Comparable[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) < 0;
    }
}