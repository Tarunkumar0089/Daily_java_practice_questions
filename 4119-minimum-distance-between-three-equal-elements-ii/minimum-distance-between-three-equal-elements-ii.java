class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                 map.put(nums[i], new ArrayList<>()); 
            }
            map.get(nums[i]).add(i);
        }
        int ans = Integer.MAX_VALUE;
        boolean found = false;
         for (List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 2; i < list.size(); i++) {
                    int dist =  2*(list.get(i) - list.get(i - 2)); 
                    ans = Math.min(ans, dist);
                    found = true;
                }
            }
        }
        return found ? ans : -1;
    }
}