
package com.shiro.alg.sort;

import com.shiro.alg.util.StdOut;

/**
 * <b>描述：排序算法实现框架</b> <br/>
 *
 * <b>时间：</b>2018-11-15<br/>
 *
 */
public abstract class AbstractSort implements Sort {

    public abstract void sort(Comparable[] a);

    /**
     * 比较元素v,w:v小于w
     * **/
    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组元素i和j
     * **/
    protected void exchange(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 在单行内打印数组
     * **/
    protected static  void show(Comparable[] a) {
        for (Comparable t : a) {
            StdOut.print(t + " ");
            StdOut.println();
        }
    }

    @Override
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i-1])) {
                return false;
            }
        }
        return true;
    }
}