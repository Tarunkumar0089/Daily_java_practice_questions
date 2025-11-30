class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double>pq=new PriorityQueue<>(Collections.reverseOrder());

        double sum=0;
        for(int num:nums){
            sum+=(num);
            pq.add((double)num);
        }
        double halve=sum/2;
        double reduce=0;
        int ops=0;

        while(reduce<halve){
            double max=pq.poll();
            double half=max/2;

            reduce+=half;
            pq.add(half);
            ops++;
        }
        return ops;
    }
}