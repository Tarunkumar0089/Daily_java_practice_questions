class Solution {
    public long maxProduct(int[] nums) {
        long max1=Long.MIN_VALUE;
        long max2=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            long num=Math.abs(nums[i]);
            if(num>max1){
                max2=max1;
                max1=num;
            }
            else if(num>max2){
                max2=num;
            }
        }
        return max1* max2* 100000;
    }
}