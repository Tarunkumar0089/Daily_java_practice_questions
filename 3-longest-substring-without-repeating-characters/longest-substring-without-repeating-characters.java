class Solution {
    public int lengthOfLongestSubstring(String s) {
        int si=0;
        int ei=0;
        int max=0;
        HashSet<Character>set=new HashSet<>();
        while(ei<s.length()){
            char ch=s.charAt(ei);
            if(set.contains(ch)){
                set.remove(s.charAt(si));
                si++;
            }else{
                set.add(ch);
                 max=Math.max(max,ei-si+1);
                ei++;
            }
        }
        return max;
    }
}