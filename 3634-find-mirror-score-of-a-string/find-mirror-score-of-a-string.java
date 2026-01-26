class Solution {
    public long calculateScore(String s) {
        Stack<Integer>[] pos = new Stack[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new Stack<>();
        }
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char mirror = (char) ('a' + 'z' - ch);
            if (!pos[mirror - 'a'].isEmpty()) {
                int mirrorIndex = pos[mirror - 'a'].pop();
                sum += (i - mirrorIndex);
            } else {
                pos[ch - 'a'].push(i);
            }
        }

        return sum;
    }
}
