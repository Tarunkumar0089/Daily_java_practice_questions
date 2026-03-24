class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][]res=new int[n][m];
        long curr=1;
        int mod=12345;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j]=(int)curr;
                curr=(curr*grid[i][j])%mod;
            }
        } 
        curr=1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                res[i][j]=(int)(res[i][j]*curr)%mod;
                curr=(curr*grid[i][j])%mod;
            }
        }
        return res;
    }
}