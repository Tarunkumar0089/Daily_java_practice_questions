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
    long totalSum = 0;
    long maxProduct = 0;
    long MOD = 1000000007;
    public int maxProduct(TreeNode root) {
        totalSum=findSum(root);
        findMax(root);
        return (int)(maxProduct % MOD);
    }
    public long findSum(TreeNode node){
        if(node==null) return 0;
        return node.val+findSum(node.left)+findSum(node.right);
    }
     public long findMax(TreeNode node) {
        if (node == null) return 0;

        long left = findMax(node.left);
        long right = findMax(node.right);
        long sub = node.val + left + right;
        long product = sub * (totalSum - sub);
        maxProduct = Math.max(maxProduct, product);
        return sub;
    }
}