
package com.shiro.alg.sort;

/**
 * <b>描述：自底向上的归并排序</b> <br/>
 *
 * <b>时间：</b>2018-11-29<br/>
 *
 */
public class MergeSortBU extends AbstractMergeSort implements Sort {


    //按2的幂 归并相邻子数组
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz -1, Math.min(lo + sz + sz - 1, N-1));
            }
        }
    }
}