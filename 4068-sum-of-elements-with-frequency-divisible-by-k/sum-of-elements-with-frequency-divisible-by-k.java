class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i , map.getOrDefault(i , 0 ) + 1);
        }
        int sum = 0;
        for(Map.Entry<Integer, Integer>  entry : map.entrySet()){
            int val = entry.getKey();
            int count = entry.getValue();
            if(count % k == 0)sum += val * count;
        }
        return sum;
    }
}