class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[]ev=new int[1001];
        for(int[]trip:trips){
            int ps=trip[0];
            int from=trip[1];
            int to=trip[2];

            ev[from]+=ps;
            ev[to]-=ps;
        }

        int cp=0;
        for(int i=0;i<ev.length;i++){
            cp+=ev[i];
            if(cp>capacity) return false;
        }
        return true;
    }
}