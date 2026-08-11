class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[]ans=new int[n+1];
        for(int[]b:bookings){
           int f=b[0];
           int l=b[1];
           int s=b[2];
           
           ans[f-1]+=s;
           ans[l]-=s;
        }

        int[]arr=new int[n];
        int curr=0;
        for(int i=0;i<n;i++){
            curr+=ans[i];
            arr[i]=curr;
        }

        return arr;
    }
}