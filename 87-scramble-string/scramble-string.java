class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        return solve(s1, s2);
    }
    private boolean solve(String s1, String s2) {
        if (s1.equals(s2))return true;
        if (s1.length()!=s2.length())return false;
        String key = s1 + "_" + s2;
        if (memo.containsKey(key)) return memo.get(key);

        int n = s1.length();
        boolean result = false;
        for (int i = 1; i < n; i++) {
            boolean swapped =solve(s1.substring(0, i), s2.substring(n - i)) &&solve(s1.substring(i), s2.substring(0, n - i));
            if (swapped) {
                result = true;
                break;
            }
            boolean notSwapped =solve(s1.substring(0, i), s2.substring(0, i)) &&
                    solve(s1.substring(i), s2.substring(i));

            if (notSwapped) {
                result = true;
                break;
            }
        }

        memo.put(key, result);
        return result;
    }
}