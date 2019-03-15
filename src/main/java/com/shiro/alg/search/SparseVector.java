/*
 */
package com.shiro.alg.search;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>描述：稀疏向量</b> <br/>
 * @date <b>时间：</b>2019-03-15<br/>
 *
 */
public class SparseVector {

    private Map<Integer, Double> vector;

    public SparseVector() {
        vector = new HashMap<>();
    }

    public int size() {
        return vector.size();
    }

    public void put(int i, double val) {
        if (!Double.valueOf(val).equals(0.0)) {
            vector.put(i, val);
        }
    }

    public double get(int i) {
        if (!vector.containsKey(i)) {
            return 0.0;
        }
        return vector.get(i);
    }

    public double dot(double[] that) {
        double sum = 0.0;
        for (Integer key : vector.keySet()) {
            sum += that[key] *  this.get(key);
        }
        return sum;
    }

    public static void main(String[] args) {
        String matrixData = "0, 0.90, 0, 0, 0; "
                + "0, 0, 0.36, 0.36, 0.38;";
        String vectorData = "0.5, 0.4, 0.36, 0.37, 0.19";
        SparseVector[] matrix = new SparseVector[5];
        double[] vector = new double[5];
        double[] result = new double[5];
        //init
        double sum = 0.0;
        for (int i = 0; i < matrix.length; i++) {
            result[i] = matrix[i].dot(vector);
        }
    }
}