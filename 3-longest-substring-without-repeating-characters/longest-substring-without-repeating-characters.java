class Solution {
    public int lengthOfLongestSubstring(String s) {
        int si=0;
        int ei=0;
        int ans=0;
        Set<Character> set = new HashSet<>();
        while(ei<s.length()){
            if(set.add(s.charAt(ei))){
                ans=Math.max(ans,ei-si+1);
                ei++;
            }
            else{
               set.remove(s.charAt(si));
               si++;
            }
        }
        return ans;
    }
}