class Solution {
    public int minOperations(int[] nums, int k) {
        if(nums.length<2) return 0;
        PriorityQueue<Long>pq=new PriorityQueue<>();
        for(int num:nums) pq.add((long)num);
        int ops=0;
        while(pq.peek()<k){
            long x=pq.poll();
            long y=pq.poll();
            long val=Math.min(x,y)*2+Math.max(x,y);
            pq.add(val);
            ops++;
        }
        return ops;
    }
}