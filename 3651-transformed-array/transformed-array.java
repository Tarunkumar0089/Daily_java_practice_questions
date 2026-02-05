class Solution {
    public int[] constructTransformedArray(int[] nums) {
         int n=nums.length;
         int[] ans=new int[n];
         for(int i=0;i<n;i++){
            if(nums[i]==0){
                ans[i]=0;
            }
            else if(nums[i]>0){
                int idx=(i+nums[i])%n;
                ans[i]=nums[idx];
            }
            else {
                int steps=Math.abs(nums[i])%n;
                int idx=(i-steps+n)%n;
                ans[i]=nums[idx];
            }

         }
         return ans;
    }
}