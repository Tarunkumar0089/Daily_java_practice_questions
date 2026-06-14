class Solution {
    public boolean checkGoodInteger(int n) {
        int num= n;
        int sum = 0;
        int sq= 0;
        while(num!=0){
            int rem = num%10;
            sq += (rem*rem);
            sum+= rem;
            num/=10;
        }
        return sq-sum>=50;
        // num = n;

    }
}