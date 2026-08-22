class Solution {
    public boolean checkDivisibility(int n) {
        int sum=sol1(n);
        int prod=sol2(n);

        if(n%(sum+prod)==0) return true;
        return false;
    }

    public int sol1(int n){
        int sum=0;
        while(n!=0){
            int rem=n%10;
            sum+=rem;
            n=n/10;
        }
        return sum;
    }

    public int sol2(int n){
        int prod=1;
        while(n!=0){
            int rem=n%10;
            prod*=rem;
            n/=10;
        }
        return prod;
    }
}