class Solution {
    static int mod=1000000007;
    public int checkRecord(int n) {
        long[][][]dp=new long[n][2][3];
        for(long[][]d:dp){
            for(long[]r:d){
                Arrays.fill(r,-1);
            }
        }

        return sol(0,0,0,n,dp);
    }
    public int sol(int idx,int a,int l,int n,long[][][]dp){
        if(idx==n) return 1;
        if(dp[idx][a][l]!=-1) return (int)dp[idx][a][l];

        long ans=0;
        ans+=sol(idx+1,a,0,n,dp);
        ans%=mod;

        if(l<2){
            ans+=sol(idx+1,a,l+1,n,dp);
            ans%=mod;
        }

        if(a==0){
           ans+=sol(idx+1,1,0,n,dp);
           ans%=mod;
        }
        return (int)(dp[idx][a][l]=ans);
    }
}