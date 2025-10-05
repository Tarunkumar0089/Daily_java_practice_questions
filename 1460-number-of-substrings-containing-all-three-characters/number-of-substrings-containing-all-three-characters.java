class Solution {
    public int numberOfSubstrings(String s) {
        int [] freq= new int[3];
        int si=0;
        int ei=0;
        int ans=0;
        while(ei<s.length()){
            freq[s.charAt(ei)-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                freq[s.charAt(si)-'a']--;
                si++;     
            }
            ans+=si;
            ei++;
        }
        return ans;
    }
}