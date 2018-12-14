
package com.shiro.alg;

import com.shiro.alg.util.In;
import com.shiro.alg.util.StdOut;
import java.util.Arrays;

/**
 * <b>描述：两数和为0</b> <br/>
 *
 * <b>时间：</b>2018-11-07<br/>
 *
 */
public class TwoSumFast {

    public static int count(int[] a) {
        int cnt = 0;
        int N = a.length;
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            if (BinarySearch.rank(-a[i], a) > i) {
                cnt ++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new In(args[0]).readAllInts();
        StdOut.println(count(a));
    }
}