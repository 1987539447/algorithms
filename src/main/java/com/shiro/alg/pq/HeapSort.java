
package com.shiro.alg.pq;

import com.shiro.alg.sort.AbstractSort;
import com.shiro.alg.sort.Sort;

/**
 * <b>描述：堆排序算法</b> <br/>
 *
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

    @Override
    protected void exchange(Comparable[] a, int i, int j) {
        super.exchange(a, i-1, j-1);
    }

    private boolean less(Comparable[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) < 0;
    }
}