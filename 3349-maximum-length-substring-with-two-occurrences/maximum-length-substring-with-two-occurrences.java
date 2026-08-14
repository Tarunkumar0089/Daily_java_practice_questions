class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen=Integer.MIN_VALUE;
        int j=0;
        int []freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            while(freq[s.charAt(i)-'a']>2){
                freq[s.charAt(j)-'a']--;
                
                j++;
            }
            maxLen=Math.max(maxLen,i-j+1);
           
        }
        return maxLen;
    }
}