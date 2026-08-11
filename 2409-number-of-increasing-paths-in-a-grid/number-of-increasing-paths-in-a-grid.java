class Solution {
    static int mod=1000000007;
    public int countPaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
       int[][]dp=new int[1001][1001];
       for(int[]d:dp){
        Arrays.fill(d,-1);
       }
       int res=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
             res=(res+sol(i,j,dp,grid,n,m))%mod;
        }
       }
     return res%mod;
       
    }

    public int sol(int i,int j, int[][]dp,int[][]grid,int n,int m){
        if(dp[i][j]!=-1) return dp[i][j];
        int[][]dir={{1,0},{0,1},{-1,0},{0,-1}};
        int res=1;
        for(int[]d:dir){
            int nr=d[0]+i;
            int nc=d[1]+j;
            if(nr<n && nc<m &&nr>=0 && nc>=0 && grid[nr][nc]>grid[i][j]){
              res=res+sol(nr,nc,dp,grid,n,m);
            }
        }

        return dp[i][j]=(res)%mod;
    }
}