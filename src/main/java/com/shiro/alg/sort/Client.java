
package com.shiro.alg.sort;

import com.shiro.alg.util.StdOut;
import java.util.Arrays;

/**
 * <b>描述：排序调用</b> <br/>
 *
 * <b>时间：</b>2018-11-15<br/>
 *
 */
public class Client {

    public static void main(String[] args) {
        String[] a = {"D","X","A","Z","C"};
        //Sort sort = new SelectionSort();
        //Sort sort = new InsertionSort();
        //Sort sort = new ShellSort();
        //Sort sort = new MergeSortBU();
        //Sort sort = new MergeSortUB();
        Sort sort = new HeapSort();
        sort.sort(a);
        System.out.println(Arrays.asList(a));
        sortCompare(args);
    }

    private static void sortCompare(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        String alg3 = args[2];
        String alg4 = args[3];
        String alg5 = args[4];
        int T = Integer.parseInt(args[5]);
        int N = Integer.parseInt(args[6]);
        double t1 = SortCompare.timeRandomInput(alg1, N, T);
        double t2 = SortCompare.timeRandomInput(alg2, N , T);
        double t3 = SortCompare.timeRandomInput(alg3, N, T);
        double t4 = SortCompare.timeRandomInput(alg4, N, T);
        double t5 = SortCompare.timeRandomInput(alg5, N, T);
        StdOut.printf("For %d random Doubles\n  ", N);
        StdOut.printf("%s is %.4f times faster than %s\n", alg2, t1/t1, alg1);
        StdOut.printf("%s is %.4f times faster than %s\n", alg3, t2/t3, alg2);
        StdOut.printf("%s is %.4f times faster than %s\n", alg3, t1/t3, alg1);
        StdOut.printf("%s is %.4f times faster than %s\n", alg4, t1/t4, alg1);
        StdOut.printf("%s is %.4f times faster than %s\n", alg5, t1/t5, alg1);
    }

}