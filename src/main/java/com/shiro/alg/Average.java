
package com.shiro.alg;

import com.shiro.alg.util.StdIn;
import com.shiro.alg.util.StdOut;

/**
 * <b>描述：求输入数值的平均值</b> <br/>
 *
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