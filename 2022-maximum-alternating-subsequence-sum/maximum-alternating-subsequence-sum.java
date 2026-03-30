class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long ans=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                ans+=nums[i]-nums[i-1];
            }
        }
        return ans;

    }
}