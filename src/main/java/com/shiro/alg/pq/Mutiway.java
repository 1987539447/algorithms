
package com.shiro.alg.pq;

import com.shiro.alg.util.In;
import com.shiro.alg.util.StdOut;

/**
 * <b>描述：索引PQ的应用，多个有序输入流归并为一个有序流：针对大数据无法执行统一排序</b> <br/>
 *
 * <b>时间：</b>2018-12-11<br/>
 *
 */
public class Mutiway {

    public static void main(String[] args) {
        int N = args.length;
        In[] streams = new In[N];
        for (int i = 0; i < N; i++) {
            streams[i] = new In(args[i]);
        }
        merge(streams);
    }

    private static void merge(In[] streams) {
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<>(N+1);
        for (int i = 0; i < N; i++) {
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }
        }

        while (!pq.isEmpty()) {
            StdOut.println(pq.minKey());
            int i = pq.delMin();
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }
        }
    }
}