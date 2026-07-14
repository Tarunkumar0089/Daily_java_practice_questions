class Solution {
    int MOD = 1000000007;
    int[][][] dp;
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        dp = new int[n + 1][max + 1][max + 1];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return solve(nums, 0, 0, 0);
    }

    public int solve(int[] nums, int idx, int g1, int g2) {
        if (idx == nums.length) {
            return (g1 != 0 && g2 != 0 && g1 == g2) ? 1 : 0;
        }

        if (dp[idx][g1][g2] != -1) {
            return dp[idx][g1][g2];
        }
        int skip = solve(nums, idx + 1, g1, g2);

        int ng1 = (g1 == 0)?nums[idx]:gcd(g1, nums[idx]);
        int take1 = solve(nums,idx+1,ng1, g2);

        int ng2 =(g2 == 0) ? nums[idx] : gcd(g2, nums[idx]);
        int take2 =solve(nums, idx +1,g1,ng2);

        return dp[idx][g1][g2] = (int) ((0L + skip + take1 + take2) % MOD);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}