class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int diff[] = new int[n];
        for(int q[]:queries){
            int start = q[0];
            int end = q[1];
            diff[start]+=1;
            if(end+1<n){
                diff[end+1]-=1;
            }
        }
        int cumsum =0;
        for(int i=0;i<n;i++){
            cumsum+=diff[i];
            if(nums[i]>cumsum){
                return false;
            }
        }
        return true;
    }
}
