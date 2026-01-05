class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];

        Arrays.fill(dp,-1);
        return sol(nums,dp,n-1);
    }
    public int sol(int[]nums,int[]dp,int i){
        if(i<0) return 0;
        
        if (dp[i] != -1) return dp[i];
        int p=nums[i]+sol(nums,dp,i-2);

        int np=sol(nums,dp,i-1);

        return dp[i]=Math.max(p,np);


    }
}