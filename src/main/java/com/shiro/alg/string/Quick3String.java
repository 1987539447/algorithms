/*
 */
package com.shiro.alg.string;

/**
 * <b>描述：三向字符串快速排序</b> <br/>
 * 按照首字母进行三向切分：大于-等于-小于，并递归处理每个段。等于段忽略首字母
 * @date <b>时间：</b>2019-09-23<br/>
 *
 */
public class Quick3String {

    //字符转索引 - 处理字符末尾
    private static int charAt(String s, int d) {
        return d < s.length() ? s.charAt(d) : -1;
    }

    public static void sort(String[] a) {
        sort(a, 0, a.length -1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        //无数组切分，递归结束
        if (hi <= lo) {
            return;
        }
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        //按首字母切分为三段：lo--lt--gt--hi
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t > v) {
                exch(a, lt++, i++);
            } else if(t < v) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }

        //递归三段，中段忽略首字母
        sort(a, lo, lt -1, d);
        sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
    }

    //交换
    private static void exch(String[] a, int source, int des) {
        String tmp = a[source];
        a[source] = a[des];
        a[des] = tmp;
    }
}