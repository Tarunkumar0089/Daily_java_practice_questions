class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int si=0;
        int ei=0;
        int currsum=0;
        int ans=0;
        HashSet<Integer>set=new HashSet<>();
        while(ei<nums.length){
             if(set.add(nums[ei])){
                currsum+=nums[ei];
                ans=Math.max(ans,currsum);
                ei++;
            }
            else{
                currsum-=nums[si];
                set.remove(nums[si]);
                si++;
            }
        }
        return ans;
    }
}