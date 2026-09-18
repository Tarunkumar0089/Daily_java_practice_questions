class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int curr=1;
        for(int num:nums){
           curr=curr*num;
           max=Math.max(max,curr);
            
           if(curr==0){
            curr=1;
           }
        }
        curr=1;
        for(int i= nums.length-1;i>=0;i--){
           curr=curr*nums[i];
           
           max=Math.max(max,curr);
           if(curr==0){
            curr=1;
           }
        }
        return max;
    }
}