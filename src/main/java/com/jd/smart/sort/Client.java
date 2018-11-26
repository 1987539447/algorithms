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
        String alg3 = args[2];
        int T = Integer.parseInt(args[3]);
        int N = Integer.parseInt(args[4]);
        double t1 = SortCompare.timeRandomInpu(alg1, N, T);
        double t2 = SortCompare.timeRandomInpu(alg2, N , T);
        double t3 = SortCompare.timeRandomInpu(alg3, N, T);
        StdOut.printf("For %d random Doubles\n  ", N);
        StdOut.printf("%s is %.4f times faster than %s\n", alg2, t1/t1, alg1);
        StdOut.printf("%s is %.4f times faster than %s\n", alg3, t2/t3, alg2);
        StdOut.printf("%s is %.4f times faster than %s\n", alg3, t1/t3, alg1);
    }

}