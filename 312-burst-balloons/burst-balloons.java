class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n+2][n+2];
        int[] arr=new int[n+2];
        for(int[]res:dp) Arrays.fill(res,-1);
        arr[0]=1;
        arr[n+1]=1;
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
       return sol(arr,1,n,dp);
    }
    public int sol(int[]arr,int l,int r,int[][]dp){
        if(l>r) return 0;
        if(dp[l][r]!=-1)return dp[l][r];
        int max=0;
        for(int i=l;i<=r;i++){
            int c=arr[l-1]*arr[i]*arr[r+1]+sol(arr,l,i-1,dp)+sol(arr,i+1,r,dp);
            max=Math.max(max,c);
        }
        dp[l][r]=max;
        return max;
    }
}