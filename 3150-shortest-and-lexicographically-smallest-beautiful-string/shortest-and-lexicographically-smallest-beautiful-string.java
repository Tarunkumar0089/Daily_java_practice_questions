class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int si=0;
        int ei=0;
        int cnt=0;
        String ans="";
        while(ei<n){
            if(s.charAt(ei)=='1'){
                cnt++;
            }

            while(cnt==k){
                while(si<=ei && s.charAt(si)=='0'){
                    si++;
                }
                

                String curr=s.substring(si,ei+1);

                if(ans.isEmpty()|| curr.length()<ans.length()){
                    ans=curr;
                }else if(curr.length()==ans.length() && curr.compareTo(ans)<0){
                     ans=curr;
                }

                if(s.charAt(si)=='1'){
                    cnt--;
                }
                si++;
            }

            ei++;
        }
        return ans;

    }
}