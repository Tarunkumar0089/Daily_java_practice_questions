class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);
        int operations = 0;
        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }
            list.remove(index);      
            list.remove(index);      
            list.add(index, minSum); 

            operations++;
        }
        return operations;
    }
    public boolean isNonDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) return false;
        }
        return true;
    }
}
