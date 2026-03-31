class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(strs, 0, m, n, dp);
    }

    public int solve(String[] strs, int i, int m, int n, int[][][] dp) {

        if (i == strs.length) return 0;

        if (dp[i][m][n] != -1) return dp[i][m][n];
        int zero = 0, one = 0;
        for (char c : strs[i].toCharArray()) {
            if (c == '0') zero++;
            else one++;
        }

        // skip
        int notTake = solve(strs, i + 1, m, n, dp);

        // take (if possible)
        int take = 0;
        if (m >= zero && n >= one) {
            take = 1 + solve(strs, i + 1, m - zero, n - one, dp);
        }

        return dp[i][m][n] = Math.max(take, notTake);
    }
}