class Solution {
    public String largestEven(String s) {
        if(s.charAt(s.length()-1)=='2'){
            return s;
        }
        int n=s.length();
        int last=n-1;
        for(int i=n-1;i>=0;i--){
            int val= s.charAt(i)-'0';
            if(val%2==1){
                last--;
            }
            else{
                break;
            }
        }
        return s.substring(0,last+1);
    }
}