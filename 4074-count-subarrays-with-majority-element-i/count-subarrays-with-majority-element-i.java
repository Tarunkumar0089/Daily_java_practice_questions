class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
     int cnt=0;
     
     for(int i=0;i<nums.length;i++){
        int t=0;
        for(int j=i;j<nums.length;j++){
            if(nums[j]==target){
                t++;
            }
            int len=j-i+1;
            if(t>(len)/2) cnt++;
        }
     }
     return cnt;
    }
}