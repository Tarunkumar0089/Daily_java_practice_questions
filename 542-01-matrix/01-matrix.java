class Solution {
    class Node{
        int first;
        int second;
        int third;
        Node(int f,int s,int t){
            this.first=f;
            this.second=s;
            this.third=t;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] vis=new boolean[n][m];
        int [][] dist=new int[n][m];
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Node(i,j,0));
                    vis[i][j]=true;
                }
                else{
                    vis[i][j]=false;
                }
            }
        }
        while(!q.isEmpty()){
            Node curr = q.poll();
            int x = curr.first;
            int y = curr.second;
            int d = curr.third;
            dist[x][y]=d;

//Left
          if(y-1>=0 && !vis[x][y-1]){
            vis[x][y-1]=true;
            q.add(new Node(x,y-1,d+1));
          }
//Right
           if(y+1<m && !vis[x][y+1]){
            vis[x][y+1]=true;
            q.add(new Node(x,y+1,d+1));
          }
//Up
           if(x-1>=0 && !vis[x-1][y]){
            vis[x-1][y]=true;
            q.add(new Node(x-1,y,d+1));
          } 
//Down
          if(x+1<n && !vis[x+1][y]){
            vis[x+1][y]=true;
            q.add(new Node(x+1,y,d+1));
          }
        }
        return dist;
    }
}