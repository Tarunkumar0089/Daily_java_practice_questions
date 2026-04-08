class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return Solve(nums,k)- Solve(nums,k-1);
    }
    public static int Solve(int [] nums, int k){
        int si=0;
        int ei=0;
        HashMap<Integer,Integer>map = new HashMap<>();
        int cnt = 0;
        while(ei<nums.length){
            int num=nums[ei];
            map.put(nums[ei],map.getOrDefault(num,0)+1);

            while(map.size()>k){
                int rem = nums[si];
                map.put(nums[si],map.get(rem)-1);
                if(map.get(rem)==0) map.remove(rem);
                si++;
            }
            cnt = cnt + ei-si+1;
            ei++;
        }
        return cnt;
}
}