class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
         int[][]dir={{1,0},{0,1},{-1,0},{0,-1}};
        int time =-1;
        while (!q.isEmpty()) {
            time++;
            int size=q.size();
            while(size-->0){
                int[]curr=q.poll();
                for(int []d:dir){
                    int ni=curr[0]+d[0];
                    int nj=curr[1]+d[1];
                     if (ni >= 0 && ni < m && nj >= 0 && nj < n &&grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        fresh--;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
        }
        return fresh == 0 ? time : -1;
    }
}