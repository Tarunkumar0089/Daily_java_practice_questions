class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int maxLen=Integer.MIN_VALUE;
        int si=0;
        int ei=0;
        while(ei<nums.length){
            if(map.getOrDefault(nums[ei],0)< k){
                map.put(nums[ei],map.getOrDefault(nums[ei],0)+1);
                ei++;
            }
            else{
                    map.put(nums[si],map.get(nums[si])-1);
                    si++;
            }
            maxLen=Math.max(maxLen,ei-si);
        }
        return maxLen;
    }
}