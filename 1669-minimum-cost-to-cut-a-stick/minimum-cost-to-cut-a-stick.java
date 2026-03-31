class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        Arrays.sort(arr);
        int[][] dp = new int[m + 2][m + 2];
        for (int[] r : dp) Arrays.fill(r, -1);
        return solve(arr, 0, m + 1, dp);
    }
      public int solve(int[] cuts, int i, int j, int[][] dp) {
        if (j - i <= 1) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int ans = (cuts[j] - cuts[i]) + solve(cuts, i, k, dp) + solve(cuts, k, j, dp);
            min = Math.min(min, ans);
        }
        return dp[i][j] = min;
    }
}