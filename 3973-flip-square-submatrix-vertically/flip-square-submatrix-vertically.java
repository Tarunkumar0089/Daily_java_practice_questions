class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n= grid.length;
        int m= grid[0].length;
        for(int i=x;i<x+k/2 && i<n;i++){
            for(int j=y;j<y+k && j<m;j++){
                int temp= grid[i][j];
                grid[i][j]= grid[x+k-1-(i-x)][j];
                grid[x+k-1-i+x][j]=temp;
            }
        }
        return grid;
    }
}