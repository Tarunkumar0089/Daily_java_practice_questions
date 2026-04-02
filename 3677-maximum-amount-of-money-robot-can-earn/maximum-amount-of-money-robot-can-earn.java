import java.util.*;

class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;

        int[][][] dp = new int[n][m][3];

        for (int[][] c : dp)for (int[] r : c)Arrays.fill(r, Integer.MIN_VALUE);

        for (int k = 0; k < 3; k++) {
            if (coins[0][0] < 0 && k > 0) dp[0][0][k] = 0;
            else dp[0][0][k] = coins[0][0];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == 0 && j == 0) continue;
                for (int k = 0; k < 3; k++) {

                    int best = Integer.MIN_VALUE;

                    // LEFT
                    if (j - 1 >= 0) {
                        if (coins[i][j] >= 0) {
                            if (dp[i][j-1][k] != Integer.MIN_VALUE)
                                best = Math.max(best, coins[i][j] + dp[i][j-1][k]);
                        } else {
                            if (dp[i][j-1][k] != Integer.MIN_VALUE)
                                best = Math.max(best, coins[i][j] + dp[i][j-1][k]);

                            if (k > 0)
                                best = Math.max(best, dp[i][j-1][k-1]);
                        }
                    }

                    // UP
                    if (i - 1 >= 0) {
                        if (coins[i][j] >= 0) {
                            if (dp[i-1][j][k] != Integer.MIN_VALUE)
                                best = Math.max(best, coins[i][j] + dp[i-1][j][k]);
                        } else {
                            if (dp[i-1][j][k] != Integer.MIN_VALUE)
                                best = Math.max(best, coins[i][j] + dp[i-1][j][k]);

                            if (k > 0)
                                best = Math.max(best, dp[i-1][j][k-1]);
                        }
                    }

                    dp[i][j][k] = best;
                }
            }
        }

        return dp[n-1][m-1][2]; 
    }
}