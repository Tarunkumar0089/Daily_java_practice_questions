class Solution {
    public int maxOperations(String s) {
      int ans=0;
      int res=0;
      for(int i=0;i<s.length();i++){
        ans+=s.charAt(i)-'0';
        if(i>0&&s.charAt(i)<s.charAt(i-1)){
            res+=ans;
        }
    }
    return res;
    }
}
