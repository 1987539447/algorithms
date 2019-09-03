/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.util.StdIn;
import com.shiro.alg.util.StdOut;

/**
 * <b>描述：负权重环检测 使用-套汇</b> <br/>
 * 汇率自然对数取反作为权重， 则汇率乘积转化为权重和
 * 构建有向图，检测是否存在负权重环
 * @date <b>时间：</b>2019-09-03<br/>
 *
 */
public class Arbitrage {

    public static void main(String[] args) {
        int V = StdIn.readInt();
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(V);
        String[] name = new String[V];

        //按行加载数据
        for (int v = 0; v < V; v++) {
            name[v] = StdIn.readString();
            for (int w = 0; w < V; w++) {
                double weight = -Math.log(StdIn.readDouble());
                digraph.addEdge(new DirectedEdge(v, w, weight));
            }
        }

        BellmanFordSP sp = new BellmanFordSP(digraph, 0);
        if (sp.hasNegativeCycle()) {
            double stake = 1000.0;
            for (DirectedEdge edge : sp.negativeCycle()) {
                StdOut.printf("%10.5f  %s", stake, name[edge.from()]);
                stake *= Math.exp(-edge.weight());
                StdOut.printf(" = %10.5f  %s\n", stake, name[edge.to()]);
            }
        } else {
            StdOut.println("No arbitrage opportunity");
        }

    }
}