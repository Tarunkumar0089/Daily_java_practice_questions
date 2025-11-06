class Solution {
    public int maxSubarraySumCircular(int[] nums) {
           int n=nums.length;
           int sum=0;
           //1
           for(int num:nums){
            sum+=num;
           }
           //2
           int min_sum=kadanes_Min(nums,n);
           
           //3
           int max_sum=kadanes_Max(nums,n);

           //4
           int circular_sum=sum-min_sum;
           if(max_sum>0){
            return Math.max(max_sum,circular_sum);
           }
           return max_sum;

    }
     public int kadanes_Max(int[]nums,int n){
        int sum=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<n;i++){
            sum=Math.max(sum+nums[i],nums[i]);
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;

    }
    public int kadanes_Min(int[]nums,int n){
        int sum=nums[0];
        int minSum=nums[0];
        for(int i=1;i<n;i++){
            sum=Math.min(sum+nums[i],nums[i]);
            minSum=Math.min(minSum,sum);
        }
        return minSum;

    }

}