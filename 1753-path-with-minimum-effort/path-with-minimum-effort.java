class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0,0,0});
        dist[0][0] = 0;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int effort = curr[2]; 
            if(r == n-1 && c == m-1)return effort;
            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    int newEffort = Math.max(effort,Math.abs(heights[r][c] - heights[nr][nc]));
                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        pq.offer(new int[]{nr, nc, newEffort});
                    }
                }
            }
        }
        
        return 0;
    }
}