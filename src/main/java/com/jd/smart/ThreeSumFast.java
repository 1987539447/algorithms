/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart;

import com.jd.smart.util.In;
import com.jd.smart.util.StdOut;
import java.util.Arrays;

/**
 * <b>描述：三数和为0</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-07<br/>
 *
 */
public class ThreeSumFast {

    public static int count(int[] a) {
        int cnt = 0;
        int N = a.length;
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (BinarySearch.rank(-a[i]-a[j], a) > j ) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new In(args[0]).readAllInts();
        StdOut.println(count(a));
    }
}