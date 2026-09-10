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
    int cnt=0;
    int totalSum=0;
    int totalCnt=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return cnt;
    }

    public void dfs(TreeNode node){
        if(node==null) {
            return ;
        }

        int currSum=totalSum;
        int currCnt=totalCnt;

        dfs(node.left);
        dfs(node.right);

        totalSum+=node.val;
        totalCnt+=1;
        
        int subtreeSum=totalSum-currSum;
        int subtreeCnt=totalCnt-currCnt;
        if(subtreeSum/subtreeCnt==node.val){
            cnt++;
        }
        
    }
}