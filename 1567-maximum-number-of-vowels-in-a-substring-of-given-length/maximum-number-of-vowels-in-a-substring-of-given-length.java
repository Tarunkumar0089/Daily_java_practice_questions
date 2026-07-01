class Solution {
    public int maxVowels(String s, int k) {
        int si=0;
        int ei=0;
        int cnt=0;
        int mx=0;
        while(ei<s.length()){
            char ch=s.charAt(ei);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')cnt++;
            if (ei-si+1 > k) {
                char c = s.charAt(si);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    cnt--;
                }
                si++;
            }

            if(ei-si+1==k) mx=Math.max(mx,cnt);
            
            ei++;
        }
    return mx;
}
}