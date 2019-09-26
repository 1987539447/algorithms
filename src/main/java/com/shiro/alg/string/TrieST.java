/*
 */
package com.shiro.alg.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>描述：基于单词查找数的字符表</b> <br/>
 * 通过键的每个字符构建树
 * 树的每一层都有R个节点 没有子节点则为空节点
 * 不存储字符，按索引建立链接关系
 * @date <b>时间：</b>2019-09-25<br/>
 *
 */
public class TrieST<T> {

    private static int R = 256;
    private Node root;

    //节点，包含一个R的数组记录子节点
    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    //获取键key的值
    public T get(String key) {
        //从根节点开始，按字母递归搜索
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return (T) x.val;
    }

    private Node get(Node x, String key, int d) {
        //按key的第d个字母匹配x节点的所有子节点
        //当前节点已经为空子节点
        if (x == null) {
            return null;
        }
        //匹配结束-最后一个字符
        if (d == key.length()) {
            return x;
        }
        //递归下一个字符
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }


    public void put(String key, T val) {
        //从根节点递归调用
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, T val, int d) {
        //新增节点 或者 覆盖
        if (x == null) {
            x = new Node();
        }
        //匹配结束
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        //设置当前字符指向，并递归子串
        char c = key.charAt(d);
        x.next[c] = put(x, key, val, d + 1);
        return x;
    }

    //延时版本 - 应使用即时记录的版本
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        //当前为空节点 返回0
        if (x == null) {
            return 0;
        }
        //否则 计算当前并递归子节点 - 包括空节点
        int cnt = 0;
        if (x.val != null) {
            cnt++;
        }
        for (char c = 0; c < R; c++) {
            cnt += size(x.next[c]);
        }
        return cnt;
    }

    //返回所有键 -- 实际是去匹配空串为前缀
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    //pre为前缀的键
    public Iterable<String> keysWithPrefix(String pre) {
        //通过一个Queue来缓存匹配到的键
        Queue<String> queue = new LinkedList<>();
        //先查找到pre对应的key，然后收集后续匹配到的键 - 有值的
        collect(get(root, pre, 0), pre, queue);
        return queue;
    }

    private void collect(Node x, String pre, Queue<String> queue) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            queue.add(pre);
        }
        //递归所有子节点 - 追加匹配的前缀 - 包括空节点
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, queue);
        }
    }

    //通配符匹配 - 仅考虑.匹配 且定长
    public Iterable<String> keysThaMatch(String pat) {
        Queue<String> queue = new LinkedList<>();
        collect(root, "", pat, queue);
        return queue;
    }

    private void collect(Node x, String pre, String pat, Queue<String> queue) {
        if (x == null) {
            return;
        }
        int d = pre.length();
        //必须长度匹配
        if (d == pat.length() && x.val != null) {
            queue.add(pre);
        }
        //递归所有子节点 - 追加匹配的前缀 - 包括空节点
        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            //下一个匹配为通配 或者字符能匹配
            if (next == '.' || next == c) {
                collect(x.next[c], pre + c, pat, queue);
            }
        }
    }

    //最长前缀 - s 能匹配到的最长的key
    public String longestPrefix(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        //按字符逐个匹配，记录最近一次匹配到key的长度
        if ( x == null) {
            return length;
        }
        if (x.val != null) {
            length = d;
        }
        if (d == length) {
            return length;
        }
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    public void delete(String key) {
        //递归搜索去删除 - 删除后需要检查是否已经为空且无下级节点
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }
        //递归结束后检查是否全为空
        //节点有值
        if (x.val != null) {
            return x;
        }
        //或者有下级节点
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) {
                return x;
            }
        }
        return null;
    }
}