class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int num=reverse(nums[i]);
            if(map.containsKey(nums[i])){
                ans=Math.min(ans,i-map.get(nums[i]));
            }
            
                map.put(num,i);
    
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int reverse(int x){
        int r=0;
        while(x>0){
            r=r*10+(x%10);
            x/=10;  
        }
        return r;
    }
}