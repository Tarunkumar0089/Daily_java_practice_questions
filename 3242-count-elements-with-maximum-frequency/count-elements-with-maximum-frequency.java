class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        int maxfreq = 0;
        for(int freq: map.values()){
            maxfreq = Math.max(freq,maxfreq);
        }
        int total =0;
        for(int freq: map.values()){
            if(freq==maxfreq){
                total+=freq;
            }
        }
        return total;
    }
}