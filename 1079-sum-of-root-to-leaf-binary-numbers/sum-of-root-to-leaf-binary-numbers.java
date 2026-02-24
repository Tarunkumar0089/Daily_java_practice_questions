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
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return sol(root, 0);
    }
    public int sol(TreeNode root, int current) {
        if (root == null) return 0;
         current = current * 2 + root.val;
        if (root.left == null && root.right == null) {
            return current;
        }
       
        return sol(root.left, current) + sol(root.right, current);
    }
}