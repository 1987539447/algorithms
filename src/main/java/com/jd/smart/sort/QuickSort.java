/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.sort;

import com.jd.smart.util.StdRandom;

/**
 * <b>描述：标准快速排序</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-12-03<br/>
 *
 */
public class QuickSort extends AbstractSort implements Sort {


    @Override
    public void sort(Comparable[] a) {

        //乱序处理，避免有序的影响
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        //优化1：对递归中较小数组使用插入排序
//        if (hi <= M + lo) {
//            InsertionSort.sort(a, lo, hi);
//            return;
//        }
        //递归结束条件
        while (lo >= hi) {
            return;
        }
        //执行切分
        int j = partition(a, lo, hi);
        //对切分后左和右递归排序
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        //优化点2：三取样切分：使用小部分元素的中位数作为切分元素
        //优化点3：熵最优：大部分重复元素--三向切分
        //选定头元素为切分元素
        Comparable v = a[lo];
        //i j指针分别从头尾扫描（先做了自减，需要+1）
        int i = lo, j = hi+1;
        while (true) {
            //从左边扫描到比切分元素大的
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            //从右边扫描到比切分元素小的
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            //循环结束条件：指针相遇
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        //交换切分元素和最后一个较小元素
        exchange(a, lo, j);
        return j;
    }
}