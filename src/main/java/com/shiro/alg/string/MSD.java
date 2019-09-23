/*
 */
package com.shiro.alg.string;


/**
 * <b>描述：高位优先排序</b> <br/>
 * 不要求字符串长度一致；定义字符串末尾的处理；从左到右按单个字符排序
 * 按首字母分为小组，每个组内再递归按照下一个字母排序
 * 控制转为插入排序的算法和阈值
 * @date <b>时间：</b>2019-09-19<br/>
 *
 */
public class MSD {

    //处理过程类似：统计--索引--分类--回写；递归处理

    //字母表基数
    private static int R = 256;

    //小数组切换为插入排序的阈值
    private static int M = 15;

    //辅助数组
    private static String[] aux;

    //字符转索引 - 处理字符末尾
    private static int charAt(String s, int d) {
        return d < s.length() ? s.charAt(d) : -1;
    }

    //对数组a按高位排序
    public static void sort(String[] a) {
        //初始化 开始排序
        int N = a.length;
        aux = new String[N];
        //对数组a按第一个字符排序
        sort(a, 0, N-1, 0);
    }

    //递归方法：将数组a从lo到hi按照d位置的字符排序
    private static  void sort(String[] a, int lo, int hi, int d) {

        //插入排序检测
        if (lo + M > hi) {
            insertionSort(a, lo, hi, d);
            return;
        }

        int[] count = new int[R];
        //频率
        for (int i = lo; i <= hi ; i++) {
            count[charAt(a[i], d) + 2]++;
        }
        //频率转索引
        for (int r = 0; r < R; r++) {
            count[r+1] += count[r];
        }
        //数据分类
        for (int i = lo; i <= hi; i++) {
             aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        //回写
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        //递归
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r+1] -1, d+1);
        }
    }

    private static void insertionSort(String[] a, int lo, int hi, int d) {
        //插入排序
    }
}