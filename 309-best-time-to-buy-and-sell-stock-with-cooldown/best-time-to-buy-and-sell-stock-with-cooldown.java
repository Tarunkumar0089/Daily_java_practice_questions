class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                    dp[i][j]= -1;
            }
        }

        return solve(prices,0,1,dp); 
    }

    public int solve(int[] prices, int i, int buy, int[][] dp) {
        if (i >= prices.length) return 0;
        if (dp[i][buy]!= -1) return dp[i][buy];
        int profit = 0;
        if(buy==1){
            profit=Math.max(-prices[i]+solve(prices,i+1,0,dp),solve(prices,i+1,1,dp));
        }else{
            profit=Math.max(prices[i]+solve(prices,i+2,1,dp),solve(prices,i+1,0,dp));
        }
        
        return dp[i][buy] = profit;
    }
}