class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j]){
                    if(cycle(grid, vis, i, j, -1, -1, grid[i][j], m, n)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean cycle(char[][] grid, boolean[][] vis, int x, int y, int px, int py, char ch, int m, int n) {
        vis[x][y] = true;
// LEFT
        if(y - 1 >= 0 && grid[x][y - 1] == ch){
            if(vis[x][y - 1] && !(x == px && y - 1 == py)){
                return true;
            } 
            else if(!vis[x][y - 1]){
                if(cycle(grid, vis, x, y - 1, x, y, ch, m, n))
                    return true;
            }
        }
// RIGHT
        if(y + 1 < n && grid[x][y + 1] == ch){
            if(vis[x][y + 1] && !(x == px && y + 1 == py)){
                return true;
            } 
            else if(!vis[x][y + 1]){
                if(cycle(grid, vis, x, y + 1, x, y, ch, m, n))
                    return true;
            }
        }
// UP
        if(x - 1 >= 0 && grid[x - 1][y] == ch){
            if(vis[x - 1][y] && !(x - 1 == px && y == py)){
                return true;
            } 
            else if(!vis[x - 1][y]){
                if(cycle(grid, vis, x - 1, y, x, y, ch, m, n))
                    return true;
            }
        }
 // DOWN
        if(x + 1 < m && grid[x + 1][y] == ch){
            if(vis[x + 1][y] && !(x + 1 == px && y == py)){
                return true;
            } 
            else if(!vis[x + 1][y]){
                if(cycle(grid, vis, x + 1, y, x, y, ch, m, n))
                    return true;
            }
        }
        return false;
    }
}
