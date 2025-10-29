class Solution {
    public int smallestNumber(int n) {
        int ans=0;
        int c=0;
        String s=Integer.toBinaryString(n);
        for(int i=0;i<s.length();i++){
            ans+=Math.pow(2,c);
            c++;
        }
        return ans;
    }
}