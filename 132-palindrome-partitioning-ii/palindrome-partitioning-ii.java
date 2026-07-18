class Solution {
    public int minCut(String s) {
        int[]dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return sol(0,s.length(),s,dp);
    }
    public int sol(int idx,int n,String s,int[]dp){
        if(idx==n ||check(idx,n-1,s)) return 0;

        if(dp[idx]!=-1) return dp[idx];

        int min=Integer.MAX_VALUE;
        for(int i=idx;i<n;i++){
            if(check(idx,i,s)){
               min=Math.min(min,1+sol(i+1,n,s,dp));

            }
        }
        return dp[idx]=min;
    }

    public boolean check(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

