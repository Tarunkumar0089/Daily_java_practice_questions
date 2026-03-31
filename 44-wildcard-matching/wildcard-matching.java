class Solution {
    public boolean isAllStars(String p, int i) {
        for (int k = 0; k <= i; k++) {
            if (p.charAt(k) != '*') return false;
        }
        return true;
    }
    public boolean solve(String s, String p, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;
        if (i < 0 && j >= 0) return isAllStars(p, j);

        if (dp[i][j] != -1) return dp[i][j] == 1;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = solve(s, p, i - 1, j - 1, dp) ? 1 : 0;
        }
        // '*'
        else if (p.charAt(j) == '*') {
            boolean take = solve(s, p, i - 1, j, dp);   // match 1 char
            boolean nottake = solve(s, p, i, j - 1, dp); // match 0 char
            dp[i][j] = (take || nottake) ? 1 : 0;
        }

        return dp[i][j] == 1;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) java.util.Arrays.fill(row, -1);

        return solve(s, p, n - 1, m - 1, dp);
    }
}