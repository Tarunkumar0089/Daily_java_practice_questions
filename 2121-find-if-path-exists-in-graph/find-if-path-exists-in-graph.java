import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return bfs(graph, source, destination, n);
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> graph, int s, int d, int n) {
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        vis[s] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == d) return true;

            for (int neigh : graph.get(curr)) {
                if (!vis[neigh]) {
                    q.add(neigh);
                    vis[neigh] = true;
                }
            }
        }
        return false;
    }
}