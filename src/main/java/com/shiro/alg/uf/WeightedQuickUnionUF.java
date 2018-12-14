
package com.shiro.alg.uf;

/**
 * <b>描述：连通性检测:加权fast-union，fast-union的优化，在连接时总是将小的树连接到大的，避免长链</b> <br/>
 *
 * <b>时间：</b>2018-11-07<br/>
 *
 */
@SuppressWarnings("all")
public class WeightedQuickUnionUF extends AbstractUF{


    //根节点分量大小：节点数
    private int[] sz;

    //初始化触点：N个连通分量，相互都不连通;初始化分量大小为1
    public WeightedQuickUnionUF(int n) {
        super(n);
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            sz[i] = 1;
        }
    }

    //找到触点p所在的连通分量
    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    //在p q建立连接
    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        //比较两个树大小，总是将小的链接到大的
        if (sz[pRoot] > sz[qRoot]) {
            //q链接到p
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            //p链接到q
            id[pRoot] = qRoot;
            sz[qRoot] = sz[pRoot];
        }
        count--;
    }
}