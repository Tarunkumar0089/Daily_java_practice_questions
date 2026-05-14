class Solution {
    public boolean isGood(int[] nums) {
       int n=nums.length-1;
       HashMap<Integer,Integer>map=new HashMap<>();
       for(int num:nums){
        map.put(num,map.getOrDefault(num,0)+1);
       }

       for(int i=1;i<n;i++){
         if(!map.containsKey(i)||map.get(i)!=1) return false;
       }
       return map.containsKey(n)&&map.get(n)==2;
    }
}