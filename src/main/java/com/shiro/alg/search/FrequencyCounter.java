
package com.shiro.alg.search;

import com.shiro.alg.util.StdIn;
import com.shiro.alg.util.StdOut;

/**
 * <b>描述：高频词汇查找</b> <br/>
 * @author <b>作者：</b> cdzhansihu@jd.com<br/>
 * <b>时间：</b>2018-12-21<br/>
 *
 */
public class FrequencyCounter {

    public static void main(String[] args) {
        int minLen = Integer.parseInt(args[0]);
        AbstractST<String, Integer> st = new SequentialSearchST<>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minLen) {
                continue;
            }
            if (st.contains(word)) {
                st.put(word, st.get(word)+1);
            } else {
                st.put(word, 1);
            }
        }

        String max = " ";
        st.put(max,0);
        for (String key : st.keys()) {
            if (st.get(max) < st.get(key)) {
                max = key;
            }
        }

        StdOut.println(max + " " + st.get(max));
    }
}