class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxH = 1, cnt = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                cnt++;
            } else {
                maxH = Math.max(maxH, cnt);
                cnt = 1;
            }
        }
        maxH = Math.max(maxH, cnt); 

        int maxV = 1;
        cnt = 1;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                cnt++;
            } else {
                maxV = Math.max(maxV, cnt);
                cnt = 1;
            }
        }
        maxV = Math.max(maxV, cnt); 
        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
    }
}
