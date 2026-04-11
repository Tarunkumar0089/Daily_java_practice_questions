class Solution {
    public int longestMountain(int[] arr) {
        int n=arr.length;
        int max=0;
        int i=1;
        while(i<n-1){
            if(arr[i-1]<arr[i] && arr[i]>arr[i+1]){
                int l=i;
                int r=i;
                
                while(l>0 && arr[l]>arr[l-1]){
                    l--;
                }

                while(r<n-1 && arr[r]>arr[r+1]){
                    r++;
                }
                max=Math.max(max,r-l+1);
                i=r;
            }
            i++;
        }
        return max;
    }
}