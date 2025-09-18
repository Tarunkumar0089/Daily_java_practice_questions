class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Step 1: Add new interval into the list
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);

        // Step 2: Sort by start time
        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Merge intervals (same as merge problem)
        List<int[]> result = new ArrayList<>();
        result.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            int[] last = result.get(result.size() - 1);
            int[] current = list.get(i);

            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
