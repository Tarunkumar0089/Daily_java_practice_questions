class Solution {
    public int climbStairs(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return sol(dp,n);
    }
    public int sol(int[]dp,int i){
        if(i<0) return 0;
        if(i==0) return 1;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=sol(dp,i-1)+sol(dp,i-2);

    }
}