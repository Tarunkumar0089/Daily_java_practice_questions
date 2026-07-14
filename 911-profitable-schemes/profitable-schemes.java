class Solution {
    static final int MOD = 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[group.length + 1][minProfit + 1][n + 1];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, 0, 0, n, minProfit, group, profit, dp);
    }

    public int solve(int i, int p, int people,int n, int minProfit,int[] group, int[] profit,int[][][] dp) {
        if (people > n)return 0;
        if (i == group.length)return (p >= minProfit) ? 1 : 0;
        if (dp[i][p][people] != -1)return dp[i][p][people];
        int notTaken = solve(i + 1, p, people, n, minProfit, group, profit, dp);
        int taken = solve(i + 1,Math.min(minProfit, p + profit[i]),people + group[i],n,minProfit,group,profit,dp);
        return dp[i][p][people] = (int) (((long) notTaken + taken) % MOD);
    }
}