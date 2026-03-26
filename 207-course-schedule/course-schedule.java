class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int[] a : prerequisites){
            list.get(a[0]).add(a[1]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] st = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!vis[i]){
                if(dfs(i, vis, st, list)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, boolean[] vis, boolean[] st, ArrayList<ArrayList<Integer>> list){

        vis[node] = true;
        st[node] = true;

        for(int nei : list.get(node)){

            if(!vis[nei]){
                if(dfs(nei, vis, st, list)){
                    return true;
                }
            }
            else if(st[nei]){
                return true;
            }

        }
        st[node] = false;
        return false;
    }
}