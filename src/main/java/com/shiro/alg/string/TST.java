/*
 */
package com.shiro.alg.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>描述：基于三向单词查找树的字符表</b> <br/>
 * 大于 - 等于 - 小于 三种分类
 * @date <b>时间：</b>2019-09-26<br/>
 *
 */
public class TST<T> {

    private Node root;

    private class Node {
        private char c;
        private T val;
        private Node left, mid, right;
    }

    public T get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        char c = key.charAt(d);
        if (c > x.c) {
            //比根节点字符打 找右边 -- 字符不移动
            return get(x.right, key, d);
        } else if (c < x.c) {
            //比根节点字符小 找左边
            return get(x.left, key, d);
        } else if (d < key.length() - 1){
            //字符相同，并且没结束 - 往下找
            return get(x.mid, key, d + 1);
        }
        return x;
    }

    public void put(String key, T val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, T val, int d) {
        char c = key.charAt(d);
        //如果根节点为空则构造一个新节点
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        //比较根节点字符和匹配字符
        //需要返回递归结束后的根节点作为上级的左 中 右
        if (c > x.c) {
            x.right = put(x.right, key, val, d);
        } else if (c < x.c) {
            x.left = put(x.left, key, val, d);
        } else if (d < key.length() - 1) {
            x.mid = put(x.mid, key, val, d +1);
        } else {
            x.val = val;
        }
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
        //否则 递归左中右 并相加
        int cnt = 0;
        if (x.val != null) {
            cnt++;
        }
        cnt += size(x.left);
        cnt += size(x.mid);
        cnt += size(x.right);
        return cnt;
    }


    //返回所有键 -- 实际是去匹配空串为前缀
    public Iterable<String> keys() {
        return keysWithPrefix(String.valueOf(root.c));
    }

    //pre为前缀的键
    public Iterable<String> keysWithPrefix(String pre) {
        //通过一个Queue来缓存匹配到的键
        Queue<String> queue = new LinkedList<>();
        //先查找到pre对应的key，然后收集后续匹配到的键 - 有值的
        collect(get(root, pre, 0), pre, queue);
        return queue;
    }

    //??
    private void collect(Node x, String pre, Queue<String> queue) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            queue.add(pre);
        }
        collect(x.mid, pre + x.c, queue);
        collect(x.mid.left, pre + x.mid.left.c, queue);
        collect(x.mid.right, pre + x.mid.right.c, queue);
    }
}