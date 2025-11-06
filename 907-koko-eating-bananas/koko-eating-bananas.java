class Solution {
    public int minEatingSpeed(int[] piles, int h) {
          int lo=1;
          int hi=0;
          for(int p:piles){
            hi=Math.max(hi,p);
          }
          while(lo<=hi){
          int mid=(lo+hi)/2;
          if(sol(piles,h,mid)){
               hi=mid-1;
          }
          else {
           lo=mid+1;
          }
          }
          return lo;
          
         
    }
    public boolean sol(int[]piles,int h,int mid){
        int hour=0;
        for(int p:piles){
            hour+=Math.ceil((double)p/mid);
        }
        if(hour<=h){
            return true;
        }
        return false;
          
        }
}