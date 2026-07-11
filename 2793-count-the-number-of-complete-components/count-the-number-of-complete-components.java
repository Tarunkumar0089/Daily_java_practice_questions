class Solution {
    int dgs;
    int tr;
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int []e:edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        int cnt=0;
        boolean[]vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dgs=0;
                tr=0;
                dfs(i,list,vis);
                if(dgs==tr*(tr-1))cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] vis){
        vis[node]=true;
         tr++;
         dgs+=graph.get(node).size();
        for(int nei:graph.get(node)){
            if(!vis[nei]){
                dfs(nei,graph,vis);
            }
        }
    }
}