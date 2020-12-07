/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        root.next = null;
        dfs(root);
        return root;
    }
    
    public void dfs(Node node) {
        if (node == null) return;
        if (node.right != null) {
            node.right.next = getFirstChild(node.next);
            dfs(node.right);
        }
        if (node.left != null) {
            node.left.next = node.right == null ? getFirstChild(node.next) : node.right;
            dfs(node.left);
        }
    }
    
    public Node getFirstChild(Node node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            return getFirstChild(node.next);
        }
        return node.left == null ? node.right : node.left;
    }
}
