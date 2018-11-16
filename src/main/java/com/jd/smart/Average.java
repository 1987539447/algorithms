/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart;

import com.jd.smart.util.StdIn;
import com.jd.smart.util.StdOut;

/**
 * <b>描述：求输入数值的平均值</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-10-31<br/>
 *
 */
public class Average {

    public static void main(String[] args) {
        double sum = 0.0;
        int count = 0;

        System.out.print("input number(ctrl+d to end)-->:");
        while (!StdIn.isEmpty()) {
            sum += StdIn.readDouble();
            count++;
            System.out.print("input number(ctrl+d to end)-->:");
        }

        double average = sum / count;
        StdOut.printf("Average is %.5f", average);
    }
}