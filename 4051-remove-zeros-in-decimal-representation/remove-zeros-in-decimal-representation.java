class Solution {
    public long removeZeros(long n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            long temp = n % 10;
            if(temp != 0) sb.append(temp);
            n /= 10;
        }
        long num = Long.parseLong(sb.reverse().toString());
        return num;
    }
}