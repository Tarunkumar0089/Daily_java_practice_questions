class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int cnt=0;
        Arrays.sort(costs);
        for(int i=0;i<costs.length;i++){
            if(costs[i]<=coins){
                coins-=costs[i];
                cnt++;
            }
        }
        return cnt;
    }
}