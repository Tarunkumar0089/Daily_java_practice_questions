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
 */class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        
        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);  
        List<List<Integer>> result = new ArrayList<>();
        
        for (int q : queries) {
            int floor = getFloor(sorted, q);
            int ceil = getCeil(sorted, q);
            result.add(Arrays.asList(floor, ceil));
        }
        
        return result;
    }
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public int getFloor(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid) <= target) {
                ans = list.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
    public int getCeil(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid) >= target) {
                ans = list.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
}
