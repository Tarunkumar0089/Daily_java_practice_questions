class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum=0;
        for(int b:batteries){
            sum+=b;
        }
        long lo=0;
        long hi=sum/n;
        long ans=0;

        while(lo<=hi){
            long mid=(lo+hi)/2;

            if(pos(mid,batteries,n)){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans;
    }
    public boolean pos(long T, int[] batteries, int n) {
        long total = 0;

        for (int b : batteries) {
            total += Math.min(b, T); 
        }
        return total >= (long) n * T;
    }
}