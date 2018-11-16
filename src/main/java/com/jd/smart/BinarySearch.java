/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart;

import com.jd.smart.util.In;
import com.jd.smart.util.StdIn;
import com.jd.smart.util.StdOut;
import java.util.Arrays;

/**
 * <b>描述：二分查找</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-10-31<br/>
 *
 */
public class BinarySearch {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = hi - lo / 2;
            if (key > a[mid]) {
                lo = mid + 1;
            }else if(key < a[mid]) {
                hi = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new In(args[0]).readAllInts();
        Arrays.sort(a);
        System.out.print("input number to search(ctrl+d to exit)-->:");
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int idx = rank(key, a);
            if (idx < 0) {
                StdOut.print(key + " is not in list \n");
            } else {
                StdOut.printf(key + " is in list\n");
            }
            System.out.print("input number to search(ctrl+d to exit)-->:");
        }
    }
}