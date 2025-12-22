class Solution {
    int n;
    int[][] dp;
    int INF = (int)1e9;
    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return sol(n - 1, 0, cost, time);
    }
   public int sol(int ind, int painted, int[] cost, int[] time) {
        if (painted >= n) return 0;
        if (ind < 0) return INF;
        if (dp[ind][painted] != -1)
            return dp[ind][painted];
        int notTake = sol(ind - 1, painted, cost, time);
        int take = cost[ind]
                + sol(ind - 1,
                     painted + time[ind] + 1,
                    cost, time);

        return dp[ind][painted] = Math.min(take, notTake);
    }
}
