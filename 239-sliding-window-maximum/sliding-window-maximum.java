class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] res = new int[nums.length-k+1];
        int idx = 0;

        int curr = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(b.val,a.val));
        for(int i=0;i<nums.length;i++){
            curr++;
            pq.add(new Pair(i,nums[i]));
            if(curr>=k){
                res[idx++] = pq.peek().val;
            }

            while(!pq.isEmpty() && pq.peek().idx <= i-k+1){ // 0
                pq.poll();
            }

        }
        return res;
    }
    static class Pair{
        int idx;
        int val;
        public Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}