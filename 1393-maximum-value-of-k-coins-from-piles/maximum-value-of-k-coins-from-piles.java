class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][]dp=new int[piles.size()][k+1];

        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return sol(0,k,piles,dp);
    }

    public int sol(int i,int k,List<List<Integer>> piles,int[][]dp){
        if(i==piles.size() || k==0) return 0;
        if(dp[i][k]!=-1) return dp[i][k];

        int np=sol(i+1,k,piles,dp);

        int currSum=0;
        int pilesSize=piles.get(i).size();
        int p=0;
        for(int x=1;x<=Math.min(pilesSize,k);x++){
            currSum+=piles.get(i).get(x-1);
            p=Math.max(p,currSum+sol(i+1,k-x,piles,dp));
        }
        return dp[i][k]=Math.max(np,p);
    }
}