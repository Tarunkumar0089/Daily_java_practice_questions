class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int[] a : prerequisites){
            list.get(a[1]).add(a[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(i,list,vis,path,st)){
                    return new int[0];
                }
            }
        }
        int[] ans = new int[numCourses];
        int i = 0;

        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }

        return ans;
    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> list,
                       boolean[] vis, boolean[] path, Stack<Integer> st){

        vis[node] = true;
        path[node] = true;

        for(int nei : list.get(node)){

            if(!vis[nei]){
                if(dfs(nei,list,vis,path,st)){
                    return true;
                }
            }
            else if(path[nei]){
                return true;
            }

        }

        path[node] = false;
        st.push(node);

        return false;
    }
}