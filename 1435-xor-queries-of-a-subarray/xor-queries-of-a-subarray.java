class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[]pre=new int[arr.length];
        pre[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            pre[i]=pre[i-1]^arr[i];
        }

        int ans[]=new int[queries.length];
        int idx=0;
        for(int[]q:queries){
           int l=q[0];
           int left=l<1?0:pre[l-1];
           int r=q[1];
           ans[idx]=pre[r]^left;
           idx++;
        }
        return ans;
    }
}