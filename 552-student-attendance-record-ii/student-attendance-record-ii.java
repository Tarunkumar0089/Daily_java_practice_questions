class Solution {
    public static final int MOD = 1_000_000_007;
    private int[][][] dp;
    public int checkRecord(int n) {
        dp = new int[n + 1][2][3];
    
        for (int i = 0; i <= n; i++) {
            for (int a = 0; a < 2; a++) {
                Arrays.fill(dp[i][a], -1);
            }
        }
        
        return sol(n, 0, 0, 0);
    }

    private int sol(int n, int i, int a, int l) {
        if (a >= 2 || l >= 3) return 0;

        if (i == n) return 1;
        if (dp[i][a][l] != -1) return dp[i][a][l];
        
        long ans = 0;
        ans = (ans + sol(n, i + 1, a, 0)) % MOD;     
        ans = (ans + sol(n, i + 1, a + 1, 0)) % MOD;  
        ans = (ans + sol(n, i + 1, a, l + 1)) % MOD; 

        return dp[i][a][l] = (int) ans;
    }
}