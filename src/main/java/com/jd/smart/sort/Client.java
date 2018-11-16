/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.sort;

import com.jd.smart.util.StdOut;

/**
 * <b>描述：排序调用</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-15<br/>
 *
 */
public class Client {

    public static void main(String[] args) {
        sortCompare(args);
    }

    private static void sortCompare(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int T = Integer.parseInt(args[2]);
        int N = Integer.parseInt(args[3]);
        double t1 = SortCompare.timeRandomInpu(alg1, N, T);
        double t2 = SortCompare.timeRandomInpu(alg2, N , T);
        StdOut.printf("For %d random Doubles\n  %s is", N , alg1);
        StdOut.printf("%.1f times faster than %s\n", t2/t1, alg2);
    }

}