class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> {
            if (a[0]==b[0]) {
                return b[1]-a[1]; 
            }
            return a[0]-b[0];  
        });
        // (1,4) (2,8)  (3,6)

        int prevfirst=intervals[0][0];
        int prevlast=intervals[0][1];
        int cnt=0;
        for(int i=1;i<intervals.length;i++){
            int currfirst=intervals[i][0];
            int currlast=intervals[i][1];

            if(currfirst>= prevfirst &&  prevlast>=currlast){
                cnt++;
            }else{
                prevfirst=currfirst;
                prevlast=currlast;
            }
        }
        return intervals.length-cnt;
    }
}