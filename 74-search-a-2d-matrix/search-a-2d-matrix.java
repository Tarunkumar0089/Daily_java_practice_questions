class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    //   int m=matrix.length;
    //   int n=matrix[0].length;
    //   int lo=0;
    //   int hi=n*m-1;
    //   while(lo<=hi){
    //     int mid=(lo+hi)/2;
    //     int row=mid/n;
    //     int col=mid%n;
    //     if(matrix[row][col]==target){
    //         return true;
    //     }
    //     else if(matrix[row][col]>target){
    //         hi=mid-1;
    //     }
    //     else{
    //         lo=mid+1;
    //     }
    //   }
    //   return false;
     int m=matrix.length;
     int n=matrix[0].length;
     int i = 0;
     int j = n-1;
     while(i<m && j>=0){
        if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j = j-1;
            }else{
                i = i+1;
            }
     }
     return false;
    }
}