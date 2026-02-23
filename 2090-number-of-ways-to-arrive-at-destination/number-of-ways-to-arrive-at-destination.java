class Solution {
    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] r : roads) {
            adj.get(r[0]).add(new long[]{r[1], r[2]});
            adj.get(r[1]).add(new long[]{r[0], r[2]});
        }
        
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});
        int mod = 1000000007;
        while(!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int)curr[1];
            if(d > dist[node]) continue;
            for(long[] nei : adj.get(node)) {
                int next = (int)nei[0];
                long time = nei[1];
                if(dist[next] > d + time) {
                    dist[next] = d + time;
                    ways[next] = ways[node];
                    pq.add(new long[]{dist[next], next});
                }
                else if(dist[next] == d + time) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }
        
        return (int)(ways[n-1] % mod);
    }
}