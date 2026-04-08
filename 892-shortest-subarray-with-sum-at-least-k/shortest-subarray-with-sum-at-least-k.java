class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long sum=0;
        PriorityQueue<long[]> pq= new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        int ans= Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
            pq.add(new long[]{sum,i});
            if(sum>=k){
                ans=Math.min(ans,i+1);
            }
            while(sum - pq.peek()[0] >=k){
                ans=Math.min(ans, (int)(i-pq.poll()[1]));
            }
        }
        return ans==Integer.MAX_VALUE? -1: ans;
    }
}