
package com.shiro.alg.search;

/**
 * <b>描述：二叉树符号表</b> <br/>
 * <b>时间：</b>2019-01-14<br/>
 *
 */
public class BST<K extends Comparable<K>, V> {

    private Node root;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node root, K key, V value) {
        if (root == null) {
            return new Node(key, value, 0);
        }
        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            root.right = put(root.right, key, value);
        } else if (cmp < 0) {
            root.left = put(root.left, key, value);
        } else {
            root.value = value;
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
        return null;
    }

    public K floor(K key) {
        return floor(root, key).key;
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
        return null;
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
        root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    public void deleteMax() {

    }

    public int size(K lo, K hi) {
        return 0;
    }

    public Iterable<K> keys(K lo, K hi) {
        return null;
    }

    public Iterable<K> keys() {
        return null;
    }

    //二叉树节点
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
}