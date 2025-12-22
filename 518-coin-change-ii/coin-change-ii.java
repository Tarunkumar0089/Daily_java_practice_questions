class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(n - 1, amount, coins, dp);
    }

    public int solve(int idx, int target, int[] coins, int[][] dp) {
        if (idx == 0) {
            return (target % coins[0] == 0) ? 1 : 0;
        }

        if (dp[idx][target] != -1)
            return dp[idx][target];
        int notTake = solve(idx - 1, target, coins, dp);
        int take = 0;
        if (coins[idx] <= target) {
            take = solve(idx, target - coins[idx], coins, dp);
        }
        return dp[idx][target] = take + notTake;
    }
}
