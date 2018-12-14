
package com.shiro.alg.uf;

/**
 * <b>描述：抽象实现</b> <br/>
 *
 * <b>时间：</b>2018-11-09<br/>
 *
 */
public abstract class AbstractUF implements UF {

    //id索引触点
    protected int[] id;
    //分量数
    protected int count;

    public AbstractUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public int count() {
        return count;
    }

    //触点p q在同一分量则连通
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public abstract int find(int p);

    public abstract void union(int p, int q);
}