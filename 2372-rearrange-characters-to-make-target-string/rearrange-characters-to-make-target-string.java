class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for(char c:s.toCharArray()){
            sCount[c-'a']++;
        }
         for(char c:target.toCharArray()){
            tCount[c-'a']++;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(tCount[i]>0){
                ans=Math.min(ans,sCount[i]/tCount[i]);
            }
        }
        return ans;
    }
}