class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diff);
        int total = 0;
        for (int val : reward2){
            total += val;
        }
        for (int i = 0; i < k; i++) {
            total += diff[n - 1 - i];
        }
        return total;
    }
    
}