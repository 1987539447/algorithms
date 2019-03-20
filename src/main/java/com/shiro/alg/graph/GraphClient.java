/*
 */
package com.shiro.alg.graph;

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
        int s = 0;
        Graph graph = new Graph(new In(dataFile));
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