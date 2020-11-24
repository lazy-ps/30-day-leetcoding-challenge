/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * Time Complexity 에서 꼴찌를 달성
 */
class Solution {
    public int rob(TreeNode root) {
        return Math.max(eat(root), noEat(root));
    }
    
    private int eat(TreeNode node) {
        if (node == null) return 0;
        int result = node.val;
        return result + noEat(node.right) + noEat(node.left);
    }
    
    private int noEat(TreeNode node) {
        if (node == null) return 0;
        int noLeft = noEat(node.left);
        int noRight = noEat(node.right);
        int yesLeft = eat(node.left);
        int yesRight = eat(node.right);
        int x = noLeft + noRight;
        int y = noLeft + yesRight;
        int w = yesLeft + noRight;
        int z = yesLeft + yesRight;
        return Math.max(Math.max(Math.max(x, y), z), w);
    }
}
