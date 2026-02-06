class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int max=0;
        int i=0;
        int j=0;
        for(j=0;j<nums.length;j++){
            while(nums[j]>(long)nums[i]*k){
                i++;
            }
            max=Math.max(max,j-i+1);
        }
        return nums.length-max;
    }
}