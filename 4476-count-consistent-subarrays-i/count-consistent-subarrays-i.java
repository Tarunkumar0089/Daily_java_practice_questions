class Solution {
    public int countConsistent(int[] nums) {
        int c = 0;
        for(int i=0;i<nums.length;i++){
            int min = Integer.MAX_VALUE;
            int and = nums[i];
            min = Math.min(min,nums[i]);
            if(and == min){
                c++;
            }
            for(int j=i+1;j<nums.length;j++){
                min = Math.min(min,nums[j]);
                and = and & nums[j];
                if(min == and){
                    c++;
                }
            }
        
        }
        return c;
    }
}