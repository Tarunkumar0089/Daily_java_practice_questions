class Solution {
    public int fib(int n) {
        int [] dp=new int[n+1];
        Arrays.fill(dp,-1);

        return sol(dp,n);
    }
    public int sol(int[]dp,int n){

        if(n<=1) return dp[n]=n;

        if(dp[n]!=-1) return dp[n];

        dp[n]=sol(dp,n-1)+sol(dp,n-2);
        return dp[n];
    }
}