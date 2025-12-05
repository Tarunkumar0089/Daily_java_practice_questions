class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int num:nums){
            total+=num;
        }
        int cnt=0;
        int left=0;
        for(int i=0;i<nums.length-1;i++){
            left+=nums[i];
            int right=total-left;
            if(Math.abs(right-left)%2==0){
                cnt++;
            }
        }
        return cnt;
    }
}