class Solution {
    long mod=1000000007;
    public int countHousePlacements(int n) {
        long []dp=new long[n];
        Arrays.fill(dp,-1);
        long res=sol(0,n,dp)%mod;
        return (int)((long)(res*res)%mod);
    }
    public long sol(int i,int n,long []dp){
        if(i>=n) return 1;
        if(dp[i]!=-1) return dp[i];

        long place=sol(i+2,n,dp);
        long notplace=sol(i+1,n,dp);
        return dp[i]=(place+notplace)%mod;
    }
}