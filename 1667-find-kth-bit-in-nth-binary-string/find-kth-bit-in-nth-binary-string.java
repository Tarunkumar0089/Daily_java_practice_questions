class Solution {
    public char findKthBit(int n, int k) {
        // Base case
        if (n == 1) {
            return '0';
        }
        int len = (int)Math.pow(2,n)-1; //length of String   
        int mid = (len + 1) / 2;    // middle position
        // Middle element
        if (k == mid) {
            return '1';
        }
        // Left half
        if (k < mid) {
            return findKthBit(n - 1, k);
        }
        // Right half
        int mirror = len - k + 1;
        char ch = findKthBit(n - 1, mirror);

        // invert the bit
        return (ch == '0') ? '1' : '0';
    }
}