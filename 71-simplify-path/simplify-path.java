class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        for (String str : arr) {
            if (str.equals("") || str.equals(".")) {
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
        if (st.isEmpty()) {
            return "/";
        }
        String res = "";
        for (String s : st) {
            res += "/" + s;
        }
        return res;
    }
}
