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
    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>>list=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int level=0;

        while(!q.isEmpty()){
            int size=q.size();
            int prev=(level%2==0)?Integer.MIN_VALUE:Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode curr=q.remove();
                int val=curr.val;
                if(level%2==0){
                    if((val%2==0)||val<=prev){
                        return false;
                    }
                }
                else{
                    if((val%2!=0)||val>=prev){
                        return false;
                    }
                }
                prev=val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            level++;
            
        }
        return true;
    }
}