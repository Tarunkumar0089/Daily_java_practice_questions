class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k %= (m * n);
        while (k-- > 0) {
            int[][] temp = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1 && j == n - 1) {
                        temp[0][0] = grid[i][j];
                    }
                    else if (j == n - 1) {
                        temp[i + 1][0] = grid[i][j];
                    }

                    else {
                        temp[i][j + 1] = grid[i][j];
                    }
                }
            }

            grid = temp;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();
            for (int x : row) list.add(x);
            ans.add(list);
        }

        return ans;
    }
}