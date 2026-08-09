class Solution {
    public long maxScore(int[] nums, int x) {
        int n=nums.length;
        long[][]dp=new long[n][2];
        for(long[]d:dp){
            Arrays.fill(d,-1);
        }
        return nums[0]+sol(1,nums[0]%2,nums,dp,n,x);
    }
    public long sol(int idx,int p,int[]nums,long[][]dp,int n,int x){
      if(idx>=n) return 0;
      if(dp[idx][p]!=-1) return dp[idx][p];
      int cp=nums[idx]%2;
      long np=sol(idx+1,p,nums,dp,n,x);
      long pi=0;
      if(cp==p){
         pi=nums[idx]+sol(idx+1,cp,nums,dp,n,x);
      }else{
        pi=nums[idx]-x+sol(idx+1,cp,nums,dp,n,x);
      }

      return dp[idx][p]=Math.max(pi,np);
    }
}