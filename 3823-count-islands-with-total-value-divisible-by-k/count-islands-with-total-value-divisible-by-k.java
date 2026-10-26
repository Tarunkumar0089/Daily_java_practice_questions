class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean[][]vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0 && !vis[i][j]){
                    long sum=solve(grid,vis,i,j,n,m);
                    if(sum%k==0){
                       ans++;
                    }
                }
            }
        }
        return (int)ans;
    }
    public long solve(int[][]grid,boolean[][]vis,int sr,int sc,int er,int ec){
        if(sr<0 || sr>=er ||sc>=ec || sc<0 ||grid[sr][sc]<=0 ||vis[sr][sc]){
           return 0;
        }
        vis[sr][sc]=true;
        long sum=(long)grid[sr][sc];
        sum+=solve(grid,vis,sr+1,sc,er,ec);
        sum+=solve(grid,vis,sr,sc+1,er,ec);
        sum+=solve(grid,vis,sr-1,sc,er,ec);
        sum+=solve(grid,vis,sr,sc-1,er,ec);
        return sum;
    }
}