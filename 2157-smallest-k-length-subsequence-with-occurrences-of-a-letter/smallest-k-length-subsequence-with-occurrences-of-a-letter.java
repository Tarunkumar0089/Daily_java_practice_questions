class Solution {
    public String smallestSubsequence(String s, int k, char letter, int r) {
       int n_letters=0;
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)==letter){
            n_letters++;
        }
       }
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            while(!st.isEmpty() && st.peek()>c &&(s.length()-i +(st.size()-1)>=k) && (st.peek() != letter|| n_letters > r)){
                if(st.pop()==letter) r++;
            }
            if (st.size() < k) {
                if (c == letter) {
                    st.push(c);
                    r --;
                } else if (k - st.size() > r) {
                    st.push(c);
                }
            }
            if (c == letter) n_letters --;
        }
       
       StringBuilder sb=new StringBuilder(st.size());
       for(Character c:st) sb.append(c);
        return  sb.toString();
    }
}
