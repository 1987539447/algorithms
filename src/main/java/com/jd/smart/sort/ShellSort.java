/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.sort;

/**
 * <b>描述：希尔排序</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-26<br/>
 *
 */
public class ShellSort extends AbstractSort implements Sort {


    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        //确定h的取值：递增序列
        int h = 1;
        while (h < N/3) {
            h = 3 * h + 1;
        }

        //h控制子数组长度，i控制子数组内的循环，j控制与j-h比较和交换
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = h; j >= h && less(a[j], a[j-h]) ; j -= h) {
                    exchange(a, j, j-h);
                }
            }
            h = h/3;
        }
    }
}