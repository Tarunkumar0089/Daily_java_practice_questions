class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
    
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && !vis[i][0])  {
                dfs(grid,vis,i,0);
            }
            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                dfs(grid, vis, i, m - 1);
            }
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !vis[0][j]) {
                dfs(grid, vis, 0, j);
            }
            if (grid[n - 1][j] == 1 && !vis[n - 1][j]) {
                dfs(grid, vis, n - 1, j);
            }
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                  count++;
                }
            }
        }
        return count;
        
    }
    public void dfs(int[][] grid,boolean[][] vis,int i,int j){
        int n = grid.length;
        int m = grid[0].length;

       vis[i][j]=true;

//Left
      if(j-1>=0 && grid[i][j - 1] == 1 && !vis[i][j - 1]){
        dfs(grid,vis,i,j-1);
      }
//Right
      if(j+1<m && grid[i][j+1] == 1 && !vis[i][j+1]){
        dfs(grid,vis,i,j+1);
      }
//Up
      if(i-1>=0 && grid[i-1][j] == 1 && !vis[i-1][j]){
        dfs(grid,vis,i-1,j);
      }
//Down
      if(i+1<n && grid[i+1][j] == 1 && !vis[i+1][j]){
        dfs(grid,vis,i+1,j);
      }
    }
}