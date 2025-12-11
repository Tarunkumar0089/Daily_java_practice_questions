class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, Integer> rowMin = new HashMap<>();
        Map<Integer, Integer> rowMax = new HashMap<>();
        Map<Integer, Integer> colMin = new HashMap<>();
        Map<Integer, Integer> colMax = new HashMap<>();

        for (int[] b : buildings){
            int x = b[0], y = b[1];

            rowMin.put(y, Math.min(rowMin.getOrDefault(y, x), x));
            rowMax.put(y, Math.max(rowMax.getOrDefault(y, x), x));

            colMin.put(x, Math.min(colMin.getOrDefault(x, y), y));
            colMax.put(x, Math.max(colMax.getOrDefault(x, y), y));
        }

        int count = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            boolean left  = rowMin.get(y) < x;
            boolean right = rowMax.get(y) > x;
            boolean above = colMin.get(x) < y;
            boolean below = colMax.get(x) > y;

            if (left && right && above && below)
                count++;
        }

        return count;
    }
}
