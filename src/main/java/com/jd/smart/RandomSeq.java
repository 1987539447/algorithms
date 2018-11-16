/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart;

import com.jd.smart.util.StdOut;
import com.jd.smart.util.StdRandom;

/**
 * <b>描述：打印N个A-B之间的随机值</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
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