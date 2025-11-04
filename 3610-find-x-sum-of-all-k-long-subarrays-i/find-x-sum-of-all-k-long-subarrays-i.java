class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n= nums.length;
        int [] res= new int[n-k+1];
        int idx=0;
        for(int i=0;i+k-1<n;i++){
            HashMap<Integer,Integer> map= new HashMap<>();
            for(int j=i;j<i+k;j++){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
            PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue<>((a,b)->{
                if(!a.getValue().equals(b.getValue())){
                    return b.getValue()-a.getValue();
                }else{
                    return b.getKey()-a.getKey();
                }
            });
            pq.addAll(map.entrySet());
            int sum=0;
            for(int l=0;l<x && !pq.isEmpty();l++){
                Map.Entry<Integer,Integer> entry=pq.poll();
                int freq=entry.getValue();
                int val =entry.getKey();
                sum+= freq*val;
            }
            res[idx]=sum;
            idx++;
        }
        return res;
    }
}