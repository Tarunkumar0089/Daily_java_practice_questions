class Solution {
    public int minimumCost(int[] nums) {
        int fmin=Integer.MAX_VALUE;
        int smin=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
           if(fmin>nums[i]){
            smin=fmin;
            fmin=nums[i];
           }else if(smin>nums[i]){
            smin=nums[i];
           }
        }
        return nums[0]+smin+fmin;
    }
}