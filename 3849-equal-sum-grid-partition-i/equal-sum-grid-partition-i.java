class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long[]rowSum=new long[n];
        long []colSum=new long[m];

        long total=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                total+=grid[i][j];
                rowSum[i]+=grid[i][j];
                colSum[j]+=grid[i][j];
            }
        }
        if(total%2!=0) return false;

        //Horizontal split
        long uper=0;
        for(int i=0;i<n-1;i++){
            uper+=rowSum[i];
            if(uper==total-uper){
                return true;
            }
        }

        //Vertical split
        long left=0;
        for(int j=0;j<m-1;j++){
            left+=colSum[j];
            if(left==total-left){
                return true;
            }
        }

        return false;
    }
}