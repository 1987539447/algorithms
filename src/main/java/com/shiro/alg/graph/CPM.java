/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.util.In;
import com.shiro.alg.util.StdOut;

/**
 * <b>描述：优先级限制并发任务管理</b> <br/>
 * @date <b>时间：</b>2019-08-27<br/>
 *
 */
public class CPM {

    public CPM(In in) {
        int N = in.readInt();
        in.readLine();// to  next line
        //增加开始结束标识点
        int s = 2 * N, t = 2 * N + 1;
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(N);
        for (int v = 0; v < N; v++) {
            String[] job = in.readLine().split("\\s+");
            //开始点到任务开始 耗时0
            digraph.addEdge(new DirectedEdge(s, v, 0.0));
            //任务执行耗时
            digraph.addEdge(new DirectedEdge(v, N + v, Double.parseDouble(job[0])));
            //任务点到结束点耗时0
            digraph.addEdge(new DirectedEdge(N + v, t, 0.0));
            //后续任务限制 增加有向边
            for (int i = 1; i < job.length; i++) {
                int successor = Integer.parseInt(job[i]);
                digraph.addEdge(new DirectedEdge(N + v, successor, 0.0));
            }
        }

        //寻找最短路径
        AcyclicSP lp = new AcyclicSP(digraph, s);
        StdOut.println("Start times:");
        for (int i = 0; i < N; i++) {
            StdOut.printf("%4d: %5.1f\n", i, lp.distTo[i]);
        }
        StdOut.printf("Finish time: %5.1f\n", lp.distTo[t]);
    }
}