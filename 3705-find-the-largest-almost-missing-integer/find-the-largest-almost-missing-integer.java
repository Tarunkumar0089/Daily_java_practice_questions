class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        if(k==1){
            int ans=-1;
            for(int x:map.keySet()){
                if(map.get(x)==1){
                    ans=Math.max(ans,x);
                }
            }
            return  ans;
        }

        if(k==n){
            int ans=-1;
            for(int x:nums){
                ans=Math.max(ans,x);
            }
            return ans;
        }

        int ans=-1;
        if(map.get(nums[0])==1){
            ans=Math.max(ans,nums[0]);
        }

        if(map.get(nums[n-1])==1){
            ans=Math.max(ans,nums[n-1]);
        }
        return ans;
    }
}