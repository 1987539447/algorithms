/*
 */
package com.shiro.alg.string;

/**
 * <b>描述：KMP算法查找字符串</b> <br/>
 * @date <b>时间：</b>2019-10-15<br/>
 *
 */
public class KMP {

    //查找模式串
    private String pat;
    //有限状态自动机表示 -- 记录应回退情况
    private int[][] dfa;


    public KMP(String pat) {
        this.pat = pat;
        //根据模式串构造DFA
        int M = pat.length();
        int R = 256; //字符表大小
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            //??
            //循环处理字符表所有字符构建dfa[][j]
            for (int c = 0; c < R; c++) {
                //设置匹配失败时的值
                dfa[c][j] = dfa[c][X];
            }
            //设置匹配成功时的值
            dfa[pat.charAt(j)][j] = j + 1;
            //重启状态
            X = dfa[pat.charAt(j)][X];
        }
    }

    //通过已经构建好的dfa来匹配字符串
    //当字符不匹配时，i不回退，j根据dfa回退到重启位置
    public int search(String txt) {
        int i, j;
        int N = txt.length();
        int M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }

        if (j == M) {
            return i - M;
        }
        return N;
    }
}