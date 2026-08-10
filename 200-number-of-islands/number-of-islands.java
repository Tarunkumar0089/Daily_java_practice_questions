class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] directions = {
            {-1, 0},   // up
            {1, 0},    // down
            {0, -1},   // left
            {0, 1}     // right
        };

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {

                    count++;
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';

                    while (!queue.isEmpty()) {

                        int[] current = queue.poll();

                        int r = current[0];
                        int c = current[1];
                          for (int[] dir : directions) {

                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            // Valid cell and land
                            if (nr >= 0 && nr < m &&
                                nc >= 0 && nc < n &&
                                grid[nr][nc] == '1') {

                                queue.offer(new int[]{nr, nc});

                                // Mark immediately when adding to queue
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}