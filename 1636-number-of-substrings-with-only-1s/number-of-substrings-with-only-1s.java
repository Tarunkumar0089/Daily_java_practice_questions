class Solution {
    public int numSub(String s) {
        long mod=1000000007;
        int n=s.length();
        long ans=0;
        long curr=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                curr++;
            }
            else{
                ans= (ans+ (curr+1)*curr/2 )% mod;
                curr=0;
            }
        }
        ans= (ans+(curr+1)*curr/2)%mod;
        return (int)(ans%mod);
    }
}
