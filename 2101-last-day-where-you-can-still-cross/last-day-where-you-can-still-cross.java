class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int ans = 0;
        int n = cells.length;
        int lo = 0, hi = n - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int[][] grid = new int[row][col];

            for (int i = mid; i >= 0; i--) {
                int r = cells[i][0] - 1;
                int c = cells[i][1] - 1;
                grid[r][c] = 1;
            }

            boolean[][] visited = new boolean[row][col];
            boolean flag = false;

            for (int j = 0; j < col; j++) {
                if (grid[0][j] == 0 && Solve(0, j, grid, visited)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                ans = mid + 1;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static boolean Solve(int r, int c, int[][] grid, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
            grid[r][c] == 1 || visited[r][c]) {
            return false;
        }
        if (r == grid.length - 1) return true;
        visited[r][c] = true;

        // up
        if (Solve(r - 1, c, grid, visited)) return true;
        // down
        if (Solve(r + 1, c, grid, visited)) return true;
        // left
        if (Solve(r, c - 1, grid, visited)) return true;
        // right
        if (Solve(r, c + 1, grid, visited)) return true;

        return false;
    }
}
