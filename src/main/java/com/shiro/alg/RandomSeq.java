
package com.shiro.alg;

import com.shiro.alg.util.StdOut;
import com.shiro.alg.util.StdRandom;

/**
 * <b>描述：打印N个A-B之间的随机值</b> <br/>
 *
 * <b>时间：</b>2018-10-31<br/>
 *
 */
public class RandomSeq {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        for (int i = 0; i < N; i++) {
            double random = StdRandom.uniform(lo, hi);
            StdOut.printf("%.2f \n", random);
        }
    }
}