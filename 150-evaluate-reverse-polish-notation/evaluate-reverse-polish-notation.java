class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                int result = operation(b, a, token);
                st.push(result);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }

    public int operation(int a, int b, String token) {
        switch (token) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }
}
