/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.sort;

import com.jd.smart.util.StdRandom;
import com.jd.smart.util.Stopwatch;

/**
 * <b>描述：排序算法比较</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-16<br/>
 *
 */
public class SortCompare {

    /**
     *
     * <b>描述：使用一个算法进行排序，并计算耗时</b> <br/>
     * @author <b>创建人：</b> cdzhansihu@jd.com<br/>
     * <b>创建时间：</b> 2018-11-16 <br/>
     * <b>修改人：</b> cdzhansihu@jd.com<br/>
     * <b>时间：</b> 2018-11-16 <br/>
     * <b>修改内容：</b>  <br/>
     */
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        Sort sortAlg = SortFactory.getSortAlg(alg);
        sortAlg.sort(a);
        return timer.elapsedTime();
    }

    /**
     *
     * <b>描述：使用算法alg将T个长度为N的数组排序</b> <br/>
     * @author <b>创建人：</b> cdzhansihu@jd.com<br/>
     * <b>创建时间：</b> 2018-11-16 <br/>
     * <b>修改人：</b> cdzhansihu@jd.com<br/>
     * <b>时间：</b> 2018-11-16 <br/>
     * <b>修改内容：</b>  <br/>
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        System.out.println("alg: " + alg + ",time: " + total);
        return total;
    }

}