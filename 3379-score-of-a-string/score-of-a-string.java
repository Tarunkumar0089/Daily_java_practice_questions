class Solution {
    public int scoreOfString(String s) {
        int sum =0;
        for(int i=1;i<s.length();i++){
            char ch1 = s.charAt(i-1);
            char ch2 = s.charAt(i);
            int n = (int) ch1;
            int m = (int) ch2;
            sum += Math.abs(n-m);
        }
        return sum;
    }
}