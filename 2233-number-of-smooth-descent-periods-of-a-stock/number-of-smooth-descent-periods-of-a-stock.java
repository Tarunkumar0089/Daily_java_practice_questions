class Solution {
    public long getDescentPeriods(int[] prices) {
        long res=1;
        long cnt=1;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]-prices[i]==1){
                cnt++;
            }
            else{
                cnt=1;
            }
            res+=cnt;
        }
        return res;
    }
}