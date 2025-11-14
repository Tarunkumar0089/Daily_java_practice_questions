class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n][n+1];   
        for(int[] q : queries){
            int r1 = q[0];
            int c1 = q[1];
            int r2 = q[2];
            int c2 = q[3];

            for(int i = r1; i <= r2; i++){
                diff[i][c1] += 1;
                diff[i][c2 + 1] -= 1;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 1; j < n; j++){
                diff[i][j] += diff[i][j - 1];
            }
        }
        int[][] ans = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans[i][j] = diff[i][j];
            }
        }

        return ans ;
    }
}
