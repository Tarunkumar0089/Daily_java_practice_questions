/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode nn = new TreeNode();
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        sol(cloned,target);
        return nn;
    }
    public void sol(TreeNode clone,TreeNode target){
        if(clone==null) return;
        if(clone.val==target.val){
            nn=clone;
        }
        sol(clone.left,target);
        sol(clone.right,target);
    }
}