class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) sum += x;
        if ((sum%2) == 1) return false;
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, target, nums, dp);
    }

    private boolean solve(int idx, int currSum, int target, int[] nums, int[][] dp) {

        if (currSum == target) return true;

        if (idx == nums.length || currSum > target) return false;

        if (dp[idx][currSum] != -1)return dp[idx][currSum] == 1;
        boolean pick = solve(idx + 1, currSum + nums[idx], target, nums, dp);
        boolean notPick = solve(idx + 1, currSum, target, nums, dp);

        dp[idx][currSum] = (pick || notPick) ? 1 : 0;

        return dp[idx][currSum] == 1;
    }
}