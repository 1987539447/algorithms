/*
 */
package com.shiro.alg.graph;

import com.shiro.alg.Bag;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <b>描述：深度优先搜索排序</b> <br/>
 * @date <b>时间：</b>2019-05-05<br/>
 *
 */
public class DepthFirstOrder {

    private boolean marked[];

    private LinkedList<Integer> pre;

    private LinkedList<Integer> post;

    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph digraph) {
        this.pre = new LinkedList<>();
        this.post = new LinkedList<>();
        this.reversePost = new Stack<>();
        this.marked = new boolean[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        pre.add(v);
        this.marked[v] = true;
        for (Integer w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return this.pre;
    }

    public Iterable<Integer> post() {
        return this.post;
    }

    public Iterable<Integer> reversePost() {
        return this.reversePost;
    }
}