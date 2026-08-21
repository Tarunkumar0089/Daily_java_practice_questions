class Solution {
    static int mod=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][]dp=new int[n+1][target+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }

        return sol(n,k,target,dp)%mod;
    }
    public int sol(int diceLeft,int k,int currTarget,int[][]dp){
        if(diceLeft==0 && currTarget==0) return 1;
        if(diceLeft==0||currTarget<0) return 0;
        if(dp[diceLeft][currTarget]!=-1) return dp[diceLeft][currTarget];
        int w=0;
        for(int i=1;i<=k;i++){
            w=(w+sol(diceLeft-1,k,currTarget-i,dp))%mod;
        }
       return dp[diceLeft][currTarget]=w;
    }
}