/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.sort;

/**
 * <b>描述：插入排序</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-15<br/>
 *
 */
public class InsertionSort extends AbstractSort implements Sort {


    /**
     * 循环数组：将当前元素插入到前面已经有序部分的合适位置
     * 当前元素与前面有序的部分比较，如果小则往前交换，否则已经到合适位置
     * **/
    @Override
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >0 && less(a[j], a[j-1]) ; j--) {
                exchange(a, j, j-1);
            }
        }
    }
}