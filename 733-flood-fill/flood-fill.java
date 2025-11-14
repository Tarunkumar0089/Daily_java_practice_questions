class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int block=image[sr][sc];
        if(block==color) return image;

        dfs(image,sr,sc,block,color);
        return image;
    }
    public void dfs(int[][] image, int sr,int sc,int block, int color){
        int m=image.length;
        int n=image[0].length;
       if(sr<0 || sc<0 || sr>=m ||sc>=n||image[sr][sc]!=block) return;
        image[sr][sc]=color;
        dfs(image,sr+1,sc,block,color);
        dfs(image,sr,sc+1,block,color);
        dfs(image,sr-1,sc,block,color);
        dfs(image,sr,sc-1,block,color);

    }
}