class Solution {
    int ans=0;
    public int minIncrements(int n, int[] cost) {
     sol(n,0,cost);
     return ans;
        
    }
    public int sol(int n,int i,int[]cost){
        if(i>=n){
            return 0;
        }
        int left=sol(n,2*i+1,cost);
        int right=sol(n,2*i+2,cost);
        ans+=Math.abs(left-right);
        return  cost[i] +Math.max(left,right);
    }
}