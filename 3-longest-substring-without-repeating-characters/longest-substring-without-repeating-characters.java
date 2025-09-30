class Solution {
    public int lengthOfLongestSubstring(String s) {
        int si=0;
        int ei=0;
        int count=0;
        int ans=0;
        Set<Character> set = new HashSet<>();
        while(ei<s.length()){
            if(set.add(s.charAt(ei))){
                count=count+1;
                ans=Math.max(ans,count);
                ei++;
            }
            else{
               count=count-1;
               set.remove(s.charAt(si));
               si++;
            }
        }
        return ans;
    }
}