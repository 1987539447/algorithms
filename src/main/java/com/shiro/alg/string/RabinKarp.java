/*
 */
package com.shiro.alg.string;

/**
 * <b>描述：Rabin-Karp算法-指纹字符串查找：基于快速的散列算法，计算匹配传的hash</b> <br/>
 * @date <b>时间：</b>2019-10-17<br/>
 *
 */
public class RabinKarp {

    //模式串
    private String pat;
    //模式串的hash
    private long pathHash;
    //模式串长度
    private int M;
    //很大的素数-计算hash用
    private long Q;
    //字母表长度
    private int R = 256;
    //hash 计算 R^(M-1) %Q
    private long RM;

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        this.Q = longRandomPrime();
        this.RM = 1;
        for (int i = 1; i <= M - 1 ; i++) {
            RM = (R * RM) % Q;
        }
        this.pathHash = hash(pat, M);
    }

    public int search(String txt) {
        int N = txt.length();
        //检查下是否开始就是匹配的
        long txtHash = hash(txt, M);
        if (pathHash == txtHash && check(0)) {
            return 0;
        }

        for (int i = M; i < N; i++) {
            //减去第一个
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            //加上最后一个  再计算hash
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (pathHash == txtHash) {
                //找到匹配
                if (check(i - M + 1)) {
                    return i - M + 1;
                }
            }
        }
        return N;
    }

    //在hash一致后 应该逐个检查字符 - 实际不去做，通过一个很大的Q使得hash冲突概率很低
    public boolean check(int i) {
        return true;
    }


    //hash算法-
    private long hash(String key, int M) {
        long h = 0L;
        for (int j = 0; j < M; j++) {
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }

    //得到一个比较大的素数
    private long longRandomPrime() {
        return 0;
    }
}