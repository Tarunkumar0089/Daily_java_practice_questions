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
     boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        heightOfTree(root);
        return balanced;
    }
    public int heightOfTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        if(Math.abs(leftHeight-rightHeight) >1){
            balanced = false;
        }
        return 1+ Math.max(leftHeight,rightHeight);
    }
}