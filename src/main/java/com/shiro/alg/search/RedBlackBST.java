
package com.shiro.alg.search;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>描述：红黑树实现</b> <br/>
 * @date <b>时间：</b>2019-03-06<br/>
 *
 */
@SuppressWarnings("all")
public class RedBlackBST<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    public void put(K key, V value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node root, K key, V value) {
        if (root == null) {
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            root.right = put(root.right, key, value);
        } else if (cmp < 0) {
            root.left = put(root.left, key, value);
        } else {
            root.value = value;
        }
        if (!isRed(root.left) && isRed(root.right)) {
            root = rotateLeft(root);
        }
        if (isRed(root.left) && isRed(root.left.left)) {
            root = rotateRight(root);
        }
        if (isRed(root.left) && isRed(root.right)) {
            flipColors(root);
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            return get(root.left, key);
        } else if (cmp > 0) {
            return get(root.right, key);
        } else {
            return root.value;
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    //删除后提升右子树最小
    private Node delete(Node root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            root.right = delete(root.right, key);
        } else if (cmp < 0){
            root.left = delete(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node t = root;
            root = min(root.right);
            root.right = deleteMin(root.right);
            root.left = t.left;
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    public boolean contains(K key) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node root) {
        if (root.right == null) {
            return root;
        }
        return max(root.right);
    }

    public K floor(K key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp == 0) {
            return root;
        } else if( cmp < 0) {
            return floor(root.left, key);
        }
        Node floorRight = floor(root.right, key);
        if ( floorRight == null) {
            return root;
        } else {
            return floorRight;
        }
    }

    public K ceiling(K key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node ceiling(Node root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            return ceiling(root.right, key);
        } else if (cmp == 0) {
            return root;
        }
        Node ceilRight = ceiling(root.left, key);
        if (ceilRight == null) {
            return root;
        } else {
            return ceilRight;
        }
    }

    public int rank(K key) {
        return rank(root, key);
    }

    private int rank(Node root, K key) {
        if (root == null) {
            return 0;
        }
        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            return size(root.left) + rank(root.right, key) + 1;
        } else if(cmp < 0) {
            return rank(root.left, key);
        } else {
            return size(root.left);
        }
    }

    public K select(int rank) {
        return select(root, rank).key;
    }

    private Node select(Node root, int rank) {
        if (root == null) {
            return null;
        }
        int size = size(root.left);
        if (size > rank) {
            return select(root.left, rank);
        } else if(size < rank) {
            return select(root.right, rank - size - 1);
        } else {
            return root;
        }
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    private Node deleteMin(Node root) {
        if (root.left == null) {
            return null;
        }
        if (!isRed(root.left) && isRed(root.left.left)) {
            root = moveRedLeft(root);
        }
        root.left = deleteMin(root.left);
        return blance(root);
    }

    private Node blance(Node root) {
        if (isRed(root.right)) {
            root = rotateLeft(root);
        }
        if (isRed(root.left) && isRed(root.left.left)) {
            root = rotateRight(root);
        }
        if (isRed(root.left) && isRed(root.right)) {
            flipColors(root);
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    private Node moveRedLeft(Node root) {
        reverseColors(root);
        if (isRed(root.right) && isRed(root.right.left)) {
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
        }
        return root;
    }

    private void reverseColors(Node root) {
        root.color = !root.color;
        root.left.color = !root.left.color;
        root.right.color = !root.right.color;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node root) {
        if (root.right == null) {
            return root.left;
        }
        root.right = deleteMax(root.right);
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    public int size(K lo, K hi) {
        return 0;
    }

    public Iterable<K> keys(K lo, K hi) {
        List<K> list = new ArrayList<>();
        keys(root, list, lo, hi);
        return list;
    }

    private void keys(Node root, List<K> list, K lo, K hi) {
        if (root == null) {
            return;
        }
        int cmpLow = lo.compareTo(root.key);
        int cmpHigh = hi.compareTo(root.key);
        if (cmpLow < 0 ) {
            keys(root.left, list, lo, hi);
        }
        if (cmpLow <= 0 && cmpHigh >=0) {
            list.add(root.key);
        }
        if (cmpHigh > 0) {
            keys(root.right, list, lo, hi);
        }

    }

    public Iterable<K> keys() {
        return keys(min(), max());
    }

    //二叉树节点
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;
        private boolean color;

        public Node(K key, V value, int size, boolean color) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    //拉平-滑动-拉高
    private Node rotateLeft(Node root) {
        Node x = root.right;
        root.right = x.left;
        x.left = root;
        x.color = root.color;
        root.color = RED;
        x.size = root.size;
        root.size = 1 + size(root.left) + size(root.right);
        return x;
    }

    private Node rotateRight(Node root) {
        Node x = root.left;
        root.left = x.right;
        x.right = root;
        x.color = root.color;
        root.color = RED;
        x.size = root.size;
        root.size = 1 + size(root.left) + size(root.right);
        return x;
    }

    private void flipColors(Node root) {
        root.color = RED;
        root.left.color = BLACK;
        root.right.color = BLACK;
    }
}