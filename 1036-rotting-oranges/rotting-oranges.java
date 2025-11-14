class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }
        if (fresh == 0) return 0;
        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            while (size--> 0) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    fresh--;
                    q.add(new int[]{x + 1, y});
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    fresh--;
                    q.add(new int[]{x - 1, y});
                }
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    fresh--;
                    q.add(new int[]{x, y + 1});
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    fresh--;
                    q.add(new int[]{x, y - 1});
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}
