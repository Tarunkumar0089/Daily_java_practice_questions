class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // If the characters match, no edit is needed, so take the value from the diagonal.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the characters don't match, take the minimum of three possibilities:
                    // 1. Replace the character in S1 with the character in S2 (diagonal).
                    // 2. Delete the character in S1 (left).
                    // 3. Insert the character from S2 into S1 (up).
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[n][m];
        // int[][]dp=new int[word1.length()][word2.length()];
        // for(int[] row:dp) Arrays.fill(row,-1);
        // return sol(0,0,word1,word2,dp);
    }
    // public int sol(int i,int j,String word1,String word2,int[][]dp){
    //     if(i==word1.length()){
    //         return word2.length()-j;
    //     }
    //     if(j==word2.length()){
    //         return word1.length()-i;
    //     }
    //     if (dp[i][j] != -1) return dp[i][j];
    //     if(word1.charAt(i)==word2.charAt(j)){
    //       return dp[i][j] = sol(i+1,j+1,word1,word2,dp);
    //     }
        
    //     int a=1+sol(i,j+1,word1,word2,dp);
    //     int b=1+sol(i+1,j+1,word1,word2,dp);
    //     int c=1+sol(i+1,j,word1,word2,dp);
    //     return dp[i][j]=Math.min(a,Math.min(b,c));

    // }
}