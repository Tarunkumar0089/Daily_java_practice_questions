class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int i = 0;
        int  stops = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int cur = startFuel;
        while (cur < target) {
            while (i < stations.length && stations[i][0] <= cur) {
                pq.offer(stations[i][1]);
                i++;
            }
            if (pq.isEmpty()) return -1;
            cur += pq.poll();
            stops++;
        }
        return stops;
    }
}
