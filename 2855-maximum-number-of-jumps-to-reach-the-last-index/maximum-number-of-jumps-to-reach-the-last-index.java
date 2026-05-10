class Solution {
    int[][] dp;
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = solve(0, 1, nums, target);
        return ans < 0 ? -1 : ans;
    }
    public int solve(int i, int j, int[] nums, int target) {
        if (i == nums.length - 1) {
            return 0;
        }
        if (j >= nums.length) {
            return -100000;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int notPick = solve(i, j + 1, nums, target);
        int pick = -1000;
        int diff = nums[j] - nums[i];
        if (-target <= diff && diff <= target) {
            pick = 1 + solve(j, j + 1, nums, target);
        }
        return dp[i][j] = Math.max(pick, notPick);
    }
}