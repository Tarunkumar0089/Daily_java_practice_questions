class Solution {
    Long [][][] dp;
    public boolean stoneGame(int[] nums) {
        long total = 0;
        for(int num: nums){
            total+=num;
        }
        dp = new Long[nums.length][nums.length][2];
        long A = Solve(nums,0,nums.length-1,0);
        return A>(total-A);

    }
    public  long Solve(int [] nums, int i, int j, int turn){
        if(i>j){
            return 0;
        }
       
        if(dp[i][j][turn]!=null) return dp[i][j][turn];
        long A = 0;
        long B = 0;
        if(turn==0){
            A = nums[i]+Solve(nums,i+1,j,1);
            B = nums[j]+Solve(nums,i,j-1,1);
        
        }
        else{
            A = Solve(nums,i+1,j,0);
            B = Solve(nums,i,j-1,0);
        }
        return dp[i][j][turn] = Math.max(A,B);

    }
}