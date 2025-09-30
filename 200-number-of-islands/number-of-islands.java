class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    Solve(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void Solve(char[][] arr, int i, int j){
        if(i<0 || i>=arr.length || j<0 || j>=arr[0].length || arr[i][j]!='1'){
            return;
        }
        arr[i][j]='0';
        Solve(arr,i+1,j);
        Solve(arr,i-1,j);
        Solve(arr,i,j+1);
        Solve(arr,i,j-1);
    }
}