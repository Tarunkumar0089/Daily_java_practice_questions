class Solution {
    public int numTeams(int[] arr) {
        int n=arr.length;
        int ans=0;
        for(int j=0;j<n;j++){
            int leftsmall=0;
            int rightsmall=0;
            int leftgreator=0;
            int rightgreator=0;
            for(int i=0;i<j;i++){
                if(arr[i]<arr[j]){
                    leftsmall++;
                }
                else if(arr[i]>arr[j]){
                    leftgreator++;
                }
            }
            for(int k=j+1;k<n;k++){
                if(arr[k]<arr[j]){
                    rightsmall++;
                }
                else if(arr[k]>arr[j]){
                    rightgreator++;
                }
            }
             ans+=leftsmall*rightgreator;
             ans+=rightsmall*leftgreator;
        }
     return ans;
    }
}