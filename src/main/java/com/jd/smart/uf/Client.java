/*
 * Copyright (c) 2015-2018 www.jd.com All rights reserved.
 * 本软件源代码版权归京东智能集团所有,未经许可不得任意复制与传播.
 */
package com.jd.smart.uf;

import com.jd.smart.util.StdIn;
import com.jd.smart.util.StdOut;

/**
 * <b>描述：UF调用测试</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-11-09<br/>
 *
 */
public class Client {

    //初始化触点--读入两个整数--已经连通则继续，否则建立连接
    public static void main(String[] args) {
        int N = StdIn.readInt();
        //UF uf = new QuickFindUF(N);
        //UF uf = new QuickUnionUF(N);
        //UF uf = new WeightedQuickUnionUF(N);
        //UF uf = new QuickUnionPathCompressionUF(N);
        UF uf = new WeightedQuickUnionPathCompressionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.print(p + "---" +q);
        }
        StdOut.print(uf.count() + "components");
    }
}