class Solution {
    public int[] diStringMatch(String s) {
        int[]perm=new int[s.length()+1];
        int low=0;
        int hi=s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I'){
                perm[i]=low++;
            }else{
                 perm[i]=hi--;
            }
        }
        perm[s.length()]=low;
        return perm;
    }
}