/*
 */
package com.shiro.alg.string;

/**
 * <b>描述：低位优先排序</b> <br/>
 * 字符串长度相同，从右向左字符为键排序，依赖于排序的稳定性
 * @date <b>时间：</b>2019-09-19<br/>
 *
 */
public class LSD {

    //1.统计频率
    //2.频率转索引
    //3.数据分类-aux
    //4.数据回写

    //通过前W个字符将数组排序（W个字符排除了数字字符串的长度不同）
    public static void  sort(String[] a, int W)  {
        //待排序字符串数
        int N = a.length;
        //所用字符表大小
        int R = 256;
        //辅助数组
        String aux[] = new String[N];

        //低位优先
        for (int d = W - 1; d >= 0 ; d--) {
            //频率统计和索引数组
            int[] count = new int[R];
            //频率统计 - 应转为字母表索引
            for (int i = 0; i < a.length; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            //频率转索引 -- 统计个数，即为改组的起始索引
            //存储时+1，则r+1对应当前分组， r对应前一个分组
            for (int r = 0; r < R; r++) {
                count[r+1] += count[r];
            }

            //数据分类 -- 将a[i]放到指定位置；从指定索引开始，并每次+1
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            //回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}