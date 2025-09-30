class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m) return false;
        int[] freq1 = new int[26];
        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }
        int[] freq2 = new int[26];
        int l=0;
        for(int r=0;r<m;r++){
            freq2[s2.charAt(r) - 'a']++;
            if (r - l + 1 == n) {
                if (matches(freq1, freq2)) return true;
                freq2[s2.charAt(l) - 'a']--;
                l++;
            }
        }
        return false;
    }
    public boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}