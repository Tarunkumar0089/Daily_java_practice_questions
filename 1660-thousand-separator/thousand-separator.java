class Solution {
    public String thousandSeparator(int n) {
        if(n==0) return"0";
        StringBuilder sb=new StringBuilder();
        int cnt=0;
        while(n!=0){
            int rem=n%10;
            n=n/10;
            cnt++;
            sb.append(rem);
            if(cnt==3 && n>0){
                sb.append('.');
                cnt=0;
            }
        }
    return sb.reverse().toString();
    }
}