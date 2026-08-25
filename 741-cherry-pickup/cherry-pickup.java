class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        Integer[][][]dp=new Integer[n][n][n];
        int ans=sol(grid,0,0,0,dp);
        return Math.max(0,ans);
    }

    public int sol(int[][] grid, int r1, int c1,int r2, Integer[][][]dp) {
        int n=grid.length;
        int c2=r1+c1-r2;

        if (r1>=n||c1>=n||r2>=n||c2>=n||grid[r1][c1]==-1||grid[r2][c2]==-1){
            return (int)-1e8;
        }
        if (r1==n-1&&c1==n-1) {
            return grid[r1][c1];
        }
        if (dp[r1][c1][r2]!=null) {
            return dp[r1][c1][r2];
        }

        int cherries = grid[r1][c1];
        if (r1 != r2||c1 != c2) {
            cherries += grid[r2][c2];
        }

        int dd=sol(grid,r1+1,c1,r2+1,dp);
        int dr=sol(grid,r1+1,c1,r2,dp);
        int rd=sol(grid,r1,c1+1,r2+1 ,dp);
        int rr=sol(grid,r1,c1+1,r2,dp);

        int maxNext=Math.max(Math.max(dd,dr),Math.max(rd, rr));

        return dp[r1][c1][r2]=cherries+maxNext;
    }
}