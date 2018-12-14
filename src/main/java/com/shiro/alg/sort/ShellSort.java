
package com.shiro.alg.sort;

/**
 * <b>描述：希尔排序</b> <br/>
 *
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
                for (int j = i; j >= h && less(a[j], a[j-h]) ; j -= h) {
                    exchange(a, j, j-h);
                }
            }
            h = h/3;
        }
    }
}