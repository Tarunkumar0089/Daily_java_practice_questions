class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n=costs.length/2;
        int totalcost=0;
        int[] diff=new int[costs.length];
        for(int i=0;i<costs.length;i++){
            totalcost+=costs[i][1];
            diff[i]=costs[i][0]-costs[i][1];;
        }
        Arrays.sort(diff);
        for(int i=0;i<n;i++){
            totalcost+=diff[i];
        }
        return totalcost;
    }
}