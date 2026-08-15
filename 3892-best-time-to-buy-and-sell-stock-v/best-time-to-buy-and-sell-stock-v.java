class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n][k + 1][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 0, prices, k, dp);
    }
    long solve(int i, int state, int[] prices, int k, long[][][] dp) {
        if (k < 0) {
            return -1000000000L;
        }
        if (i == prices.length) {
            if (state == 0) {
                return 0;
            }
            return -1000000000L;
        }
        if (dp[i][k][state] != -1) {
            return dp[i][k][state];
        }
        long normal = -1000000000L;
        long shortSell = -1000000000L;
        long skip = solve(i + 1, state, prices, k, dp);
        if (state == 0) {
            // Normal Buy
            normal = -prices[i]+solve(i+1,1,prices,k,dp);
            // Short Sell
            shortSell = prices[i]+ solve(i+1,2,prices,k,dp);

        } 
        else if (state==1) {
            // Sell normal stock
            normal=prices[i]+solve(i+1,0,prices,k-1,dp);
        } 
        else {
            // Buy back after short selling
            shortSell=-prices[i]+solve(i+1,0,prices,k-1,dp);
        }

        return dp[i][k][state]=Math.max(normal, Math.max(shortSell, skip));
    }
}