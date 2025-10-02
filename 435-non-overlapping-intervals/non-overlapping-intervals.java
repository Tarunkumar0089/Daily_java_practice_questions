class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int cnt=0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int last=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<last){
                 cnt++;
            }
            else{
                last=intervals[i][1];
            }
        }
        return cnt;
    }
}