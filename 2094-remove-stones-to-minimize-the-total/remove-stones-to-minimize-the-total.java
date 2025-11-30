class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int sum=0;
        for(int p:piles){
            sum+=p;
            pq.add(p);
        }
        int ops=0;
        while(ops<k){
            int num=pq.poll();
            int remove=num/2;
            int pile=num-remove;
            pq.add(pile);
            sum-=remove;
            ops++;
        }
        return sum;

    }
}