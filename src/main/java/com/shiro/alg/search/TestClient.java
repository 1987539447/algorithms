
package com.shiro.alg.search;

import com.shiro.alg.util.StdIn;
import com.shiro.alg.util.StdOut;
import java.util.Arrays;
import java.util.List;

/**
 * <b>描述：测试客户端</b> <br/>
 *
 * <b>时间：</b>2018-12-21<br/>
 *
 */
public class TestClient {

    private static final List<String> TEXT = Arrays.asList("S","E","A","R","C","H","E","X","A","M","P","L","E");


    public static void main(String[] args) {
        //testBST();
        testRBBST();
    }

    private static void testRBBST() {
        RedBlackBST<String,String> bst = new RedBlackBST<>();
        for (String charater : TEXT) {
            bst.put(charater,"");
        }
        bst.delete("E");
        for (String key : bst.keys()) {
            System.out.println(key);
        }
    }

    private static void testBST() {
        BST<String,String> bst = new BST();
        for (String charater : TEXT) {
            bst.put(charater,"");
        }
        bst.delete("E");
        for (String key : bst.keys()) {
            System.out.println(key);
        }
    }

    public void testBS() {
        ST<String, Integer> st;
        //st = new SequentialSearchST<>();
        st = new BinarySearchST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String key : st.keys()) {
            StdOut.println(key + " " + st.get(key));
        }
    }
}