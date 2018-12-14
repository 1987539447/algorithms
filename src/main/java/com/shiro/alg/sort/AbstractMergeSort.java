
package com.shiro.alg.sort;

/**
 * <b>描述：归并排序抽象</b> <br/>
 *
 * <b>时间：</b>2018-11-29<br/>
 *
 */
public abstract class AbstractMergeSort extends AbstractSort {

    protected Comparable[] aux;


    //归并：数组左、右均已经有序
    protected void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        //复制数据到辅助数组
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        //进行归并，复制回原数组
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                //左边取完直接取右边
                a[k] = aux[j++];
            } else if(j > hi) {
                //右边取完直接取左边
                a[k] = aux[i++];
            }else if (less(aux[i] , aux[j])) {
                //取左或右中小的
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }
}