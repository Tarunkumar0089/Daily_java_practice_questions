class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        // long ans=nums[0];
        // for(int i=1;i<n;i++){
        //     if(nums[i]>nums[i-1]){
        //         ans+=nums[i]-nums[i-1];
        //     }
        // }
        // return ans;
        long[][]dp=new long[n][2];
        return solve(nums,0,0,dp);
    }
    public static long solve(int[]nums,int i,int s,long[][]dp){
        if(i==nums.length) return 0;

        if(dp[i][s]!=0) return dp[i][s];
        long np=solve(nums,i+1,s,dp);
        long p=0;
        if(s==0){
            p=nums[i]+solve(nums,i+1,1,dp);
        }
        else{
            p=-nums[i]+solve(nums,i+1,0,dp);
        }
        return dp[i][s]=Math.max(np,p);

    }
}