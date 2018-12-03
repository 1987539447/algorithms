/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.sort;

import com.jd.smart.util.StdRandom;

/**
 * <b>描述：三向切分快速排序</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-12-03<br/>
 *
 */
public class QuickSort3Way extends AbstractSort implements Sort {


    //切分元素扩展为数组-滑窗: lo--lt--(i)--gt--hi
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        //递归结束条件
        if (lo >= hi) {
            return;
        }
        //滑动窗口，并交换
        //三种处理：
        //1.比切分值小，与lt交换并向右滑动
        // 2.比切分值大,与gt交换
        //3.与切分值相同 扩大窗口
        Comparable v = a[lo];
        int lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exchange(a, i++, lt++);
            } else if(cmp > 0) {
                exchange(a, i, gt--);
            }else {
                i++;
            }
        }
        //递归调用
        sort(a, lo, lt -1);
        sort(a, gt + 1, hi);
    }
}