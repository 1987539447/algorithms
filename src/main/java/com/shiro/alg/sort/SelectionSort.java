
package com.shiro.alg.sort;

/**
 * <b>描述：选择排序</b> <br/>
 *
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