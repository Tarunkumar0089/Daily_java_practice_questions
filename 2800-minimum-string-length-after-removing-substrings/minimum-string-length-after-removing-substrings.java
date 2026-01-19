class Solution {
    public int minLength(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            st.push(s.charAt(i));
               if(st.size()>=2){
                char a=st.peek();
                st.pop();
                char b=st.peek();
                if((a=='B' && b=='A' )|| (a=='D' && b=='C')){
                     st.pop();
                }
                else{
                st.push(a);
                }
            }
        }
        return st.size();
    }
}