class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=maxValue(matrix, j);
                }
            }
        }
        return matrix;
    }
    public int maxValue(int[][] matrix, int col){
        int max=-1;
        for(int i=0;i<matrix.length;i++){
            max=Math.max(matrix[i][col],max);
        }
        return max;
    }
}