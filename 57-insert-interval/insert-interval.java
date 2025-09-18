class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int interval[]: intervals){
            list.add(interval);
        }
        list.add(newInterval);
        list.sort((a,b)->a[0]-b[0]);
        List<int[]> merge = new ArrayList<>();
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        for(int i=1;i<list.size();i++){
            int s = list.get(i)[0];
            int e = list.get(i)[1];
            if(s<=end){
                end = Math.max(end,e);
            }
            else{
                merge.add(new int[]{start,end});
                start = s;
                end = e;
            }
        }
        merge.add(new int[]{start,end});
        return merge.toArray(new int[merge.size()][]);
    }
}