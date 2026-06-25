class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int x : cuts)list.add(x);
        list.add(n);
        Collections.sort(list);
        int m = cuts.length;
        dp = new int[m + 2][m + 2];
        for (int[] row : dp)Arrays.fill(row, -1);
        return solve(1, m, list);
    }

    int solve(int i, int j, List<Integer> cuts) {

        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {

            int cost = cuts.get(j + 1) - cuts.get(i - 1)
                    + solve(i, k - 1, cuts)
                    + solve(k + 1, j, cuts);

            ans = Math.min(ans, cost);
        }

        return dp[i][j] = ans;
    }
}