class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int cn=total - x;
        if (cn==0) return nums.length;
        if (cn< 0) return -1;        
        int start=0,sum=0,ans=-1;
        for (int end=0;end<nums.length;end++) {
            sum += nums[end]; 
            while (sum>cn) { 
                sum-=nums[start++];
            }
            if (sum==cn) { 
                ans=Math.max(ans, end-start+1);
            }
        } 
        return ans==-1?-1:nums.length-ans;
    }
}
