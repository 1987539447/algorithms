/*
 */
package com.shiro.alg.string;

/**
 * <b>描述：字符串匹配查找</b> <br/>
 * @date <b>时间：</b>2019-10-15<br/>
 *
 */
public class StringSearch {


    /**
     * 暴力算法查找：依次匹配
     * **/
    public static int basicSerch(String txt, String pat) {
        int N = txt.length();
        int M = pat.length();
        //外层指针：当前匹配起始位置
        for (int i = 0; i < N - M; i++) {
            int j = 0;
            //内层指针：模式串匹配字符
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                return i;
            }
        }
        return N;
    }


    /**
     * 暴力匹配，指针同时移动，不匹配时回退
     * **/
    public static int basicBackSearch(String txt, String pat) {
        int i = 0, j = 0;
        int N = txt.length();
        int M = pat.length();
        //i j 匹配时同时移动
        for (i = 0, j = 0; i < N && j < M ; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                //不匹配时i 回退已匹配的，j回退到0
                i -= j;
                j = 0;
            }
        }
        if (j == M) {
            return i - j;
        }
        return N;
    }
}