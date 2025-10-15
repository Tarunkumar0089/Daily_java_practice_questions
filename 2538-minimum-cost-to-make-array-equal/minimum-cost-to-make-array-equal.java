class Solution {
    public long minCost(int[] nums, int[] cost) {
        int lo=Integer.MAX_VALUE;
        int hi=Integer.MIN_VALUE;
        for(int num:nums){
            lo=Math.min(lo,num);
            hi=Math.max(hi,num);
        }
        long res=Long.MAX_VALUE;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            long find=Find(nums,cost,mid);
            res=Math.min(find,res);

            long left=Find(nums,cost,mid-1);
            long right=Find(nums,cost,mid+1);
            if(left<right){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return res;
    }
    public static long Find(int[] nums, int[] cost, int target){
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ans+=0;
            }else{
                ans+= (long)Math.abs(nums[i]-target)*cost[i];
            }
        }
        return ans;

        
    }
}