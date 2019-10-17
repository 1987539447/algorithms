/*
 */
package com.shiro.alg.string;

/**
 * <b>描述：Boyer-Moore字符串匹配算法：不匹配时更快的向后移动</b> <br/>
 * @date <b>时间：</b>2019-10-17<br/>
 *
 */
public class BoyeMoore {

    //记录后移跳跃数据
    private int[] right;

    //匹配模式串
    private String pat;

    public BoyeMoore(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];

        //初始化-不包含在模式串中的字符
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }

        //包含在模式串中的字符-最右的位置
        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j;
        }
    }

    public int search(String txt) {
        int N = txt.length();
        int M = this.pat.length();
        //不匹配时跳跃距离
        int skip = 0;
        for (int i = 0; i < N - M; i += skip) {
            skip = 0;
            //从右往左匹配
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    //根据txt中不匹配字符在模式串中位置来跳跃
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) {
                        skip = 1;
                    }
                    break;
                }
            }
            //找到匹配
            if (skip == 0) {
                return i;
            }
        }
        //未找到匹配-返回N
        return N;
    }
}