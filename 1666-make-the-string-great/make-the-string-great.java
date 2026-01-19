class Solution {
    public String makeGood(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            st.push(s.charAt(i));
            if(st.size()>=2){
                char a=st.pop();
                char b=st.peek();
                if(Math.abs(a-b)==32){
                    st.pop();
                }
                else{
                    st.push(a);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}