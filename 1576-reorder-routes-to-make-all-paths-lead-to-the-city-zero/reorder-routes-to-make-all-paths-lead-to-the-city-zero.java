class Solution {
     int changes=0;
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : connections) {
            int a = edge[0];
            int b = edge[1];

            graph[a].add(new int[]{b, 1});

           
            graph[b].add(new int[]{a, 0});
        }

        boolean[] visited = new boolean[n];

         dfs(0, graph, visited);
         return changes;
    }

    public void dfs(int node, List<int[]>[] graph, boolean[] visited) {

        visited[node] = true;
        for (int[] edge : graph[node]) {

            int next = edge[0];
            int cost = edge[1];

            if (visited[next]) {
                continue;
            }

            changes += cost;
             dfs(next, graph, visited);
        }
    }
}