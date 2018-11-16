/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.sort;

/**
 * <b>描述：选择排序</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-15<br/>
 *
 */
public class SelectionSort extends AbstractSort implements Sort {

    /**
     * 选择排序：循环数组，选择最小的元素跟当前元素交换
     * **/
    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if (less(a[j],a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }
}