package search;
// 搜索二叉树
public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N; // its nums of subtree's nodes

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        return root.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.val;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp < 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }
}
