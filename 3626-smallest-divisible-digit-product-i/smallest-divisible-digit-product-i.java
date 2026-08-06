class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<101;i++){
            int d=i;
            int p=1;
            while(d!=0){
                int rem=d%10;
                p*=rem;
                d=d/10;
            }
            if(p%t==0) return i;
        }
        return 0;
    }
}