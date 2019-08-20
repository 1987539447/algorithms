/*
 */
package com.shiro.alg.graph;

/**
 * <b>描述：最小生成树API定义</b> <br/>
 * @date <b>时间：</b>2019-08-19<br/>
 *
 */
public abstract class MST {

    MST(EdgeWeightedGraph graph){
    }

    public abstract Iterable<Edge> edges();

    public abstract double weight();

    public static void main(String[] args) {

    }
}