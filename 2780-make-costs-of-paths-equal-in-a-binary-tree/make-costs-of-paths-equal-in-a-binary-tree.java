class Solution {
    int[]dp;
    public int minIncrements(int n, int[] cost) {
        dp=new int[n+1];
        int req=maxCost(cost,1);
        return sol(n,cost,1,req,dp);
    }
    public int sol(int n,int[]cost,int i,int req,int[]dp){
        int left=2*i;
        int right=2*i+1;
        if(left>=n && right>=n){
            return req-cost[i-1];
        }
        int self=req-dp[i-1];
        return self+ sol(n,cost,2*i,req-cost[i-1]-self,dp)+ sol(n,cost,2*i+1,req-cost[i-1]-self,dp);
    }
    public int maxCost(int[]cost,int i){
        if(i>cost.length){
            return 0;
        }
        return dp[i-1]=cost[i-1]+Math.max(maxCost(cost,2*i),maxCost(cost,2*i+1));
    }
}