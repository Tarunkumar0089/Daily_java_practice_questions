class Solution {
    public int maxDistance(int[] colors) {
        // int n = colors.length;
        // int maxDist = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = n - 1; j > i; j--) {
        //         if (colors[i] != colors[j]) {
        //             maxDist = Math.max(maxDist, j - i);
        //         }
        //     }
        // }

        // return maxDist;

        int n = colors.length;
        int max = 0;
        for (int i =n -1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                max = i;
                break;
            }
        }

        for(int i=0;i<n;i++){
            if(colors[i]!=colors[n-1]){
                max=Math.max(max,n-1-i);
            }
        }
        return max;
    }
}