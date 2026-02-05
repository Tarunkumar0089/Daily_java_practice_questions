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
     List<Integer>list=new ArrayList<>();
    public void sol(TreeNode root){
        if(root==null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        sol(root);
        return list;
    }
}