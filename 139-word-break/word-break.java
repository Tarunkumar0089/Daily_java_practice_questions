class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()]; // FIX
        HashSet<String> set = new HashSet<>(wordDict);

        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        return sol(s, 0, dp, set, maxLen);
    }

    public boolean sol(String s, int i, Boolean[] dp, HashSet<String> set, int maxLen) {
        if (i == s.length()) return true;

        if (dp[i] != null) return dp[i]; 

        for (int j = i + 1; j <= s.length() && j - i <= maxLen; j++) {
            if (set.contains(s.substring(i, j)) && sol(s, j, dp, set, maxLen)) {
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }
}