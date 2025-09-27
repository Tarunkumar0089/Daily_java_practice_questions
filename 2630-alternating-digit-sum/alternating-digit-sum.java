class Solution {
    public int alternateDigitSum(int n) {
       String str = String.valueOf(n);
       int num = 0;
       for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
        int digit = ch-'0';
        if(i%2==0){
            num+=digit;
        }
        else{
            num-=digit;
        }
       }
       return num; 
    }
}