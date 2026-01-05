class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(m - 1, n - 1, dp, grid);
    }
    public int solve(int i, int j, int[][] dp, int[][] grid) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return (int)1e9;
        if (dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + solve(i - 1, j, dp, grid);
        int left = grid[i][j] + solve(i, j - 1, dp, grid);
        return dp[i][j] = Math.min(up, left);
    }
}
