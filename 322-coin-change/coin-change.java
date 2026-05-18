class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = solve(n - 1, amount, coins, dp);
        return ans >= (int)1e9 ? -1 : ans;
    }

    public int solve(int idx, int target, int[] coins, int[][] dp) {
        if (idx == 0) {
            if (target % coins[0] == 0)
                return target / coins[0];
            else
                return (int)1e9;
        }
        
        if (dp[idx][target] != -1) return dp[idx][target];
        int notTake = solve(idx - 1, target, coins, dp);
        int take = (int)1e9;
        if (coins[idx] <= target) {
            take = 1 + solve(idx, target - coins[idx], coins, dp);
        }

        return dp[idx][target] = Math.min(take, notTake);
    }
}
