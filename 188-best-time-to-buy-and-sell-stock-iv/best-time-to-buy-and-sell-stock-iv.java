class Solution {

    public int solve(int i, int buy, int cap, int[] prices, int[][][] dp){
        if(i == prices.length || cap == 0)return 0;

        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];

        int profit;
        if(buy == 1){
            profit = Math.max(
                    -prices[i] + solve(i+1,0,cap,prices,dp),
                    solve(i+1,1,cap,prices,dp)
            );
        }
        else{
            profit = Math.max(
                    prices[i] + solve(i+1,1,cap-1,prices,dp),
                    solve(i+1,0,cap,prices,dp)
            );
        }

        return dp[i][buy][cap] = profit;
    }

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];

        for(int i=0;i<n;i++)
            for(int j=0;j<2;j++)
                for(int c=0;c<=k;c++)
                    dp[i][j][c] = -1;

        return solve(0,1,k,prices,dp);
    }
}