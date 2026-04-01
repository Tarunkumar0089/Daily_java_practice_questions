class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] health, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][4]; 
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = health[i];
            robots[i][2] = directions.charAt(i);
            robots[i][3] = i;
        }

        Arrays.sort(robots, (a, b) -> a[0] - b[0]);
        Stack<int[]> st = new Stack<>();
        for (int[] robot : robots) {
            if (robot[2] == 'R') {
                st.push(robot);
            } else {
                while (!st.isEmpty() && st.peek()[2] == 'R') {
                    int[] top = st.peek();

                    if (top[1] > robot[1]) {
                        top[1]--;
                        robot[1] = 0;
                        break;
                    } else if (top[1] < robot[1]) {
                        robot[1]--;
                        st.pop();
                    } else {
                        st.pop();
                        robot[1] = 0;
                        break;
                    }
                }

                if (robot[1] > 0) {
                    st.push(robot);
                }
            }
        }

        List<int[]> survivors = new ArrayList<>(st);
        Collections.sort(survivors, (a, b) -> a[3] - b[3]);
        List<Integer> result = new ArrayList<>();
        for (int[] r : survivors) {
            result.add(r[1]);
        }
        return result;
    }
}