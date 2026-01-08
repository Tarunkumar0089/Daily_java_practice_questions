class Solution {
    int NEG = -1000000000;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1][n2];
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        return sol(0, 0, nums1, nums2, dp);
    }
    public int sol(int i, int j, int[] a, int[] b, int[][] dp) {
        if (i == a.length || j == b.length)return NEG;
        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int prod = a[i] * b[j];
        int pick = prod + sol(i + 1, j + 1, a, b, dp);
        int skipA = sol(i + 1, j, a, b, dp);
        int skipB = sol(i, j + 1, a, b, dp);

        dp[i][j] = Math.max(prod, Math.max(pick, Math.max(skipA, skipB)));
        return dp[i][j];
    }
}
