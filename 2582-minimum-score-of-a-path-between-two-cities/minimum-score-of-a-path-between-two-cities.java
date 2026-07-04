class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[]graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int[]r:roads){
            int u=r[0];
            int v=r[1];
            int w=r[2];

            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }

        Queue<Integer>q=new LinkedList<>();

        boolean[] vis=new boolean[n+1];

        q.offer(1);
        vis[1]=true;

        int ans=Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int curr=q.poll();

            for(int []e:graph[curr]){
                int next=e[0];
                int weight=e[1];
                ans=Math.min(ans,weight);

                if(!vis[next]){
                    vis[next]=true;
                    q.offer(next);
                }
            }
        }
        return ans;
    }
}