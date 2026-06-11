
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]>list =new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[]last=list.get(list.size()-1);
            int[]next=intervals[i];

            if(next[0]<=last[1]){
                last[1]=Math.max(last[1],next[1]);
            }else{
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}