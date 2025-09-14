class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap();
        for(int num:nums){
            if(num%2==0){
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        int ans=-1;
        int max=Integer.MIN_VALUE;
        for(int key:map.keySet()){
            if(map.get(key)==max){
                ans=Math.min(key,ans);
                max=map.get(key);
            }else if(map.get(key)>max){
                max=map.get(key);
                ans=key;
            }
        }
        return ans;
    }
}