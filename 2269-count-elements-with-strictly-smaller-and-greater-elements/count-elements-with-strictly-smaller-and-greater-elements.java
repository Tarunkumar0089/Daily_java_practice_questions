class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        // return nums.length-2;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(min>nums[i]){
                min=nums[i];
            }
            if(max<nums[i]){
                max=nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(min<nums[i] && max>nums[i]){
                cnt++;
            }
        }
        return cnt;
    }
}