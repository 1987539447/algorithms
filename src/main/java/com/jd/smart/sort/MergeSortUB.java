/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.sort;

/**
 * <b>描述：归并排序 自顶向下, 1/2NlgN ~ NlgN 比较，6N logN 访问</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-29<br/>
 *
 */
public class MergeSortUB extends AbstractMergeSort implements Sort {


    //自顶向下的归并
    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        //只有一个元素时结束递归
        if (hi <= lo) {
            return;
        }
        //分别递归左边和右边，然后归并
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

}