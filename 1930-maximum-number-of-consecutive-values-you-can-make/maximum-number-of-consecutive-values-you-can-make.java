class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int r=0;
        for(int i=0;i<coins.length;i++){
            if(coins[i]>r+1) break;
            r+=coins[i];
        }
        return r+1;
    }
}