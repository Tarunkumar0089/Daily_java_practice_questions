class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[]arr=path.split("/");
        for (String str:arr) {
            if (str.equals("")||str.equals(".")) {
                continue;
            }
            if (!str.equals("..")) {
                st.push(str);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
        }

        if(st.isEmpty()){
            return "/";
        }

        String res="";
        for(String s:st){
            res+="/"+s;
        }
        return res;

        
    }
}
