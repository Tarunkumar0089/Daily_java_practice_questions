class Solution {
    public long maximumScore(int[] nums, String s) {
        int n=nums.length;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        long ans=0;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(s.charAt(i)=='1'){
                ans+= pq.poll();
            }
        }
        return ans;
            
    }
}