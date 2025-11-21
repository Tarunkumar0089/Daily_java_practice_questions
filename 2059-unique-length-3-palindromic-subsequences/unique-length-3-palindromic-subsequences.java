class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first,-1);
        Arrays.fill(last,-1);

        for(int i=0;i<n;i++){
          int ch=s.charAt(i)-'a';

          if(first[ch]==-1){
            first[ch]=i;
          }
          last[ch]=i;
        }

        int cnt=0;
        for (int c = 0; c < 26; c++) {
            if (first[c] != -1 && last[c] != -1 && first[c] < last[c]) {
                boolean[] seen = new boolean[26];
                for (int i = first[c] + 1; i < last[c]; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                    
                }
                for (boolean b : seen) {
                    if (b) cnt++;
                }
            }
        }
        return cnt;
    }
}