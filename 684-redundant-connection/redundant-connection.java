class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            boolean[] vis = new boolean[n + 1];
            if (dfs(u, v, vis, list)) {
                return e; 
            }
            list.get(u).add(v);
            list.get(v).add(u);
        }
        return new int[]{};
    }

    public boolean dfs(int src, int target, boolean[] vis,ArrayList<ArrayList<Integer>>list) {
        if (src == target) return true;
        vis[src] = true;
        for (int nei : list.get(src)) {
            if (!vis[nei]) {
                if (dfs(nei, target, vis, list)) {
                    return true;
                }
            }
        }

        return false;
    }
}