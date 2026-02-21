class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt=0;
        for(int i=left;i<=right;i++){
            if(prime(Integer.bitCount(i))){
                cnt++;
            }
        }
        return cnt;
    }
    public boolean prime(int num){
        if(num<=1) return false;
        int c=0;
        for(int i=2;i*i<=num;i++){
            if(num%i==0) c++;
        }
        if(c==0)return true;
        return false;
    }
}