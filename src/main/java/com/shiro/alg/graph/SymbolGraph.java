/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.util.In;
import com.shiro.alg.util.StdIn;
import com.shiro.alg.util.StdOut;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>描述：符号图</b> <br/>
 * @date <b>时间：</b>2019-04-16<br/>
 *
 */
public class SymbolGraph {

    private Map<String, Integer> st;
    private String[] keys;
    private Graph graph;

    public SymbolGraph(String file, String delimiter) {

        this.st = new HashMap<>();
        //第一次循环建立索引和反向索引
        In in = new In(file);
        while (in.hasNextLine()) {
            String[] row = in.readLine().split(delimiter);
            for (String key : row) {
                if (!st.containsKey(key)) {
                    st.put(key, st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String key : st.keySet()) {
            keys[st.get(key)] = key;
        }

        this.graph = new Graph(st.size());
        //第二次循环建立图
        in = new In(file);
        while (in.hasNextLine()) {
            String[] row = in.readLine().split(delimiter);
            int v = st.get(row[0]);
            for (int i = 1; i < row.length; i++) {
                this.graph.addEdge(v, st.get(row[i]));
            }
        }

    }

    /**key 是否是图的一个顶点**/
    boolean contains(String key) {
        return st.containsKey(key);
    }
    /**key的索引**/
    public int index(String key) {
        return st.get(key);
    }

    /**索引v对应的顶点**/
    public String name(int v) {
        return keys[v];
    }

    /**内部隐藏的图**/
    public Graph G() {
        return this.graph;
    }

    public static void main(String[] args) {
        String dataFile = "";
        String delimiter = "";
        SymbolGraph symbolGraph = new SymbolGraph(dataFile, delimiter);
        Graph graph = symbolGraph.G();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            for (int w : graph.adj(symbolGraph.index(source))) {
                StdOut.println("  " + symbolGraph.name(w));
            }
        }
    }
}