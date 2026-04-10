class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        int ans = Integer.MAX_VALUE;
        boolean f = false;

        for (List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i <= list.size() - 3; i++) {
                    int a = list.get(i);
                    int b = list.get(i + 1);
                    int c = list.get(i + 2);

                    int dist = Math.abs(a - b)+ Math.abs(b - c)+ Math.abs(c - a);

                    ans = Math.min(ans, dist);
                    f = true;
                }
            }
        }

        return f ? ans : -1;
    }
}