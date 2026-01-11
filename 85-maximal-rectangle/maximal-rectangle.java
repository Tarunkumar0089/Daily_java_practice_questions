class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }

        return maxArea;
    }
    public int largestRectangleArea(int[] arr) {
        int area = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int height = arr[st.pop()];
                int temp = i;
                if (st.isEmpty()) {
                    area = Math.max(area, height * temp);
                } else {
                    int l = st.peek();
                    area = Math.max(area, height * (temp - l - 1));
                }
            }
            st.push(i);
        }

        int r = arr.length;
        while (!st.isEmpty()) {
            int h = arr[st.pop()];
            if (st.isEmpty()) {
                area = Math.max(area, h * r);
            } else {
                int l = st.peek();
                area = Math.max(area, h * (r - l - 1));
            }
        }

        return area;
    }
}
