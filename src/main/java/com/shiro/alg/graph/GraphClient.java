/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.Bag;
import com.shiro.alg.util.In;
import com.shiro.alg.util.StdOut;

/**
 * <b>描述：图测试客户端</b> <br/>
 * @date <b>时间：</b>2019-03-20<br/>
 *
 */
public class GraphClient {

    public static void main(String[] args) {
        String dataFile = "D:\\workspace\\algorithms\\src\\main\\resources\\data\\tinyCG.txt";
        Graph graph = new Graph(new In(dataFile));

        //printGraph(graph);
        //printComponents(graph);
        printHasCycle(graph);
        printIsTwoColorable(graph);

    }

    private static void printHasCycle(Graph graph) {
        Cycle cycle = new Cycle(graph);
        if (cycle.hasCycle()) {
            StdOut.println("this graph has cycle...");
        } else {
            StdOut.println("thi graph has not cycle...");
        }
    }

    private static void printIsTwoColorable(Graph graph) {
        TwoColor twoColor = new TwoColor(graph);
        if (twoColor.isTwoColorable()) {
            StdOut.println("this graph can be fill with two color...");
        } else {
            StdOut.println("this graph can not be fill with two color...");
        }
    }

    private static void printComponents(Graph graph) {

        DFC dfc = new DFC(graph);
        int M = dfc.count();
        StdOut.println(M +" components");

        Bag<Integer>[] components = new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<>();
        }

        for (int v = 0; v < graph.V(); v++) {
            components[dfc.id(v)].add(v);
        }

        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

    }

    private static void printGraph(Graph graph) {
        int s = 0;
        //Paths path = new DepthFirstPaths(graph, s);
        Paths path = new BreadFirstPaths(graph, s);
        for (int v = 0; v < graph.V(); v++) {
            StdOut.print(s + " to " + v + ": ");
            if (path.hasPathTo(v)) {
                for (int x : path.pathTo(v)) {
                    if (x == s) {
                        StdOut.print(x);
                    } else {
                        StdOut.print("-" + x);
                    }
                }
            } else {
                StdOut.print("not connected");
            }
            StdOut.println();
        }
    }
}