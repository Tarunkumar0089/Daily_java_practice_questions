class Solution {
    public int numWaterBottles(int n, int k) {
        int ans=n;
        int empty=n;
        while(empty>=k){
            ans++; 
            empty=empty-k+1 ;
        }
        return ans;
    }
}