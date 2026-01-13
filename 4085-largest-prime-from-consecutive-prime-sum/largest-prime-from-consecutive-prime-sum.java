class Solution {
    public int largestPrime(int n) {
       boolean[] prime=new boolean[n+1];
       Arrays.fill(prime,true);
      if(n>=0) prime[0]=false;
      if(n>=1) prime[1]=false;
       for(int i=2;i*i<=n;i++){
           if(prime[i]){
            for(int j=i*i;j<=n;j+=i){
                prime[j]=false;
            }
           }
       }
       int sum=0;
       int ans=0;
       for(int i=2;i<=n;i++){
         if(!prime[i]) {
            continue;
         }
         sum+=i;
         if(sum>n) break;
         if(prime[sum]) ans=sum;
       }
       return ans;
    }
}