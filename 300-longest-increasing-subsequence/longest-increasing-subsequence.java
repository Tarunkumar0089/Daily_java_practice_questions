class Solution {
    public int lengthOfLIS(int[] nums) {
    //      int[][]dp=new int[nums.length][nums.length+1];
    //   for(int[]r:dp)   Arrays.fill(r,-1);
    //        return sol(0,-1,nums,dp);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);  
        int ans =1;
        for (int i=0; i<n; i++) {
            for (int j=0;j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            ans = Math.max(ans,dp[i]);
        }

        return ans;

    }
    // public int sol(int i,int prev,int[]nums,int[][]dp){
    //   if(i==nums.length) return 0;
    //   if(dp[i][prev+1]!=-1) return dp[i][prev+1];

    //   int np=sol(i+1,prev,nums,dp);
    //   int p=0;
    //   if(prev==-1 || nums[i]>nums[prev]){
    //     p=1+sol(i+1,i,nums,dp);
    //   }
    //   return dp[i][prev+1]=Math.max(p,np);
    // }
}