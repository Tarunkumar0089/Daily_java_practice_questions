class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int curr=0;
        int ans=0;
        
        map.put(0,1);
        for(int num:nums){
            if(num%2==1) curr++;
            if(map.containsKey(curr-k)){
                ans+= map.get(curr-k);
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return ans;
    }
}