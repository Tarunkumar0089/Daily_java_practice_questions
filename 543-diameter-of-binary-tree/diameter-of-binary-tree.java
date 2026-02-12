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
   public int ans=0;
   public int height(TreeNode root){
     if(root==null){
        return 0;
     }
     int left=height(root.left);
     int right=height(root.right);
     ans=Math.max(left+right,ans);
     return Math.max(left,right)+1;
   }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }
 // class TreeInfo {
    //     int ht;
    //     int dia;
    //     public TreeInfo(int dia, int ht) {
    //         this.ht = ht;
    //         this.dia = dia;
    //     }
    // public TreeInfo diameter(TreeNode root) {
    //     if (root == null) {
    //         return new TreeInfo(0, 0);
    //     }

    //     TreeInfo left = diameter(root.left);
    //     TreeInfo right = diameter(root.right);

    //     int myHeight = Math.max(left.ht, right.ht) + 1;
    //     int dia1 = left.dia;
    //     int dia2 = right.dia;
    //     int dia3 = left.ht + right.ht + 1;
    //     int myDia = Math.max(dia1, Math.max(dia2, dia3));

    //     return new TreeInfo(myDia, myHeight);
    // }
}
