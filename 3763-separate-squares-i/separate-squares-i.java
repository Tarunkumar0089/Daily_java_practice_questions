class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double totalArea = 0;
        for (int[] s : squares) {
            double y = s[1];
            double len = s[2];
            totalArea += len * len;
            low = Math.min(low, y);
            high = Math.max(high, y + len);
        }
        double target = totalArea / 2.0;
        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;

            if (areaBelow(mid, squares) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return (low + high) / 2.0;  
    }

    private double areaBelow(double mid, int[][] squares) {
        double area = 0;

        for (int[] s : squares) {
            double y = s[1];
            double len = s[2];
            if (mid >= y + len) {
                area += len * len;
            } else if (mid > y) {
                area += len * (mid - y);
            }
        }
        return area;
    }
}
