class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        return sol(grid, 0, 0, vis, n, m);
    }

    public boolean sol(int[][] grid, int r, int c, boolean[][] vis, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m || vis[r][c]) return false;
        if (r == n - 1 && c == m - 1) return true;
        vis[r][c] = true;
        int curr = grid[r][c];
        // LEFT
        if (c - 1 >= 0 && (curr == 1 || curr == 3 || curr == 5)) {
            int next = grid[r][c - 1];
            if (next == 1 || next == 4 || next == 6) {
                if (sol(grid, r, c - 1, vis, n, m)) return true;
            }
        }

        // RIGHT
        if (c + 1 < m && (curr == 1 || curr == 4 || curr == 6)) {
            int next = grid[r][c + 1];
            if (next == 1 || next == 3 || next == 5) {
                if (sol(grid, r, c + 1, vis, n, m)) return true;
            }
        }

        // UP
        if (r - 1 >= 0 && (curr == 2 || curr == 5 || curr == 6)) {
            int next = grid[r - 1][c];
            if (next == 2 || next == 3 || next == 4) {
                if (sol(grid, r - 1, c, vis, n, m)) return true;
            }
        }

        // DOWN
        if (r + 1 < n && (curr == 2 || curr == 3 || curr == 4)) {
            int next = grid[r + 1][c];
            if (next == 2 || next == 5 || next == 6) {
                if (sol(grid, r + 1, c, vis, n, m)) return true;
            }
        }

        return false;
    }
}