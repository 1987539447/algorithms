
package com.shiro.alg.search;

import com.shiro.alg.util.StdIn;
import com.shiro.alg.util.StdOut;

/**
 * <b>描述：测试客户端</b> <br/>
 *
 * <b>时间：</b>2018-12-21<br/>
 *
 */
public class TestClient {

    public static void main(String[] args) {
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