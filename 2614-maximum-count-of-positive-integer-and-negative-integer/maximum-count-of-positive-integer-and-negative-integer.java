class Solution {
    public int maximumCount(int[] nums) {
        int c=0;
        int c1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                c1++;
            }
            else if(nums[i]<0){
                c++;
            }
            
        }
        int p=Math.max(c,c1);
        return p;
    }
}