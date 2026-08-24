class Solution {
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        int[]pref=new int[n];
        pref[0]=stones[0];
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]+stones[i];
        }

        int[]dp=new int[n];
        dp[n-1]=pref[n-1];
        for (int i=n-2;i>0;i--){
            int p=pref[i]-dp[i+1];
            int np=dp[i+1];

            dp[i]=Math.max(p,np);
        }
            

        return dp[1];

         // return sol(1,pref,n);

    }

    // public int sol(int i,int[]pref,int n){
    //     if(i==n-1) {
    //         return pref[n-1];
    //     }

    //     int p=pref[i]- sol(i+1,pref,n);
    //     int np=sol(i+1,pref,n);
    //     return Math.max(p,np);
    // }
}