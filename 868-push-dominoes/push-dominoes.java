class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();
        int last = -1;      
        char lastForce = 'L';
        for (int i = 0; i <= n; i++) {
            char curr = (i == n) ? 'R' : arr[i]; 
            if (curr == '.') continue;
            if (curr == lastForce) {
                for (int k = last + 1; k < i; k++) {
                    arr[k] = curr;
                }
            } else if (lastForce == 'R' && curr == 'L') {
                int l = last + 1, r = i - 1;
                while (l < r) {
                    arr[l++] = 'R';
                    arr[r--] = 'L';
                }     
            }
            last = i;
            lastForce = curr;
        }
        return new String(arr);
    }
}
