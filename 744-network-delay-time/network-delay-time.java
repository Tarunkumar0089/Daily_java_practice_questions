class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t : times){
            adj.get(t[0]).add(new int[]{t[1], t[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0] - b[0] );

        pq.add(new int[]{0, k});

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if(time > dist[node]) continue;

            for(int[] neigh : adj.get(node)){
                int newNode = neigh[0];
                int wt = neigh[1];

                if(time + wt < dist[newNode]){
                    dist[newNode] = time + wt;
                    pq.add(new int[]{dist[newNode], newNode});
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}