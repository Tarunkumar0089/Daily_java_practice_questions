class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
       
        int [] ans=new int[n];
        int [] freq=new int[n+1];

        for(int i=0;i<n;i++){
            freq[A[i]]++;
            freq[B[i]]++;
            ans[i]=checkcount(freq,n);
        }
        return ans;
    }
    public static int checkcount(int [] freq,int n){
        int c=0;
        for(int i=1;i<=n;i++){
            if(freq[i]==2){
                c++;
            }
        }
        return c;
    }
}