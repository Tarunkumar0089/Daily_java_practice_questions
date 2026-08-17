class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : s.toCharArray()) {
                uniqueChars.add(c);
            }
            return uniqueChars.size() < s.length();
            
        }

        List<Integer> diffIndices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffIndices.add(i);
            }
        }

        if (diffIndices.size() == 2) {
            int i = diffIndices.get(0);
            int j = diffIndices.get(1);
            return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
        }

        return false;
    }
}