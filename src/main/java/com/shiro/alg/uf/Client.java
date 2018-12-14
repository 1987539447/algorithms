
package com.shiro.alg.uf;

import com.shiro.alg.util.StdIn;
import com.shiro.alg.util.StdOut;

/**
 * <b>描述：UF调用测试</b> <br/>
 *
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