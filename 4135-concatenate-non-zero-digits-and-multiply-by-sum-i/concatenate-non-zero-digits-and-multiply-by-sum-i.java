class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        int sum=0;
        StringBuilder sb=new StringBuilder();

        while(n!=0){
            int rem=n%10;
            sum+=rem;
            if(rem!=0){
                sb.append(rem);
            }
            n=n/10;
        }
        sb.reverse();
        long num=Long.parseLong(sb.toString());
       long ans=sum*num;
       return ans;
    }
}