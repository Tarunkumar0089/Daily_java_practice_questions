class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1]- preSum[i - 1][j - 1]+ mat[i - 1][j - 1];
            }
        }
        int max = 0;
        for (int side = 1; side <= Math.min(m, n); side++) {
            for (int i = 0; i + side <= m; i++) {
                for (int j = 0; j + side <= n; j++) {
                    int sum = preSum[i + side][j + side] - preSum[i][j + side]- preSum[i + side][j] + preSum[i][j];
                    if (sum <= threshold) {
                        max = side;
                    }
                }
            }
        }
        return max;
    }
}
