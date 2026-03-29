class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer>left=new PriorityQueue<>();
        PriorityQueue<Integer>right=new PriorityQueue<>();
        int n=costs.length;
        int i=0;
        int j=n-1;

        for(int x=0;x<candidates &&i<=j;x++){
            left.add(costs[i++]);
        }
        for(int x=0;x<candidates &&i<=j;x++){
            right.add(costs[j--]);
        }
        long ans=0;
        while(k-->0){
            int l = left.isEmpty() ? Integer.MAX_VALUE : left.peek();
            int r = right.isEmpty() ? Integer.MAX_VALUE : right.peek();
            
            if(l<=r){
                ans+=left.poll();

                if(i<=j&&left.size()<candidates){
                    left.add(costs[i++]);
                }
             }

             else{
                ans+=right.poll();

                if(i<=j&&right.size()<candidates){
                    right.add(costs[j--]);
                }
             }
             
        }
        return ans;

    }
}