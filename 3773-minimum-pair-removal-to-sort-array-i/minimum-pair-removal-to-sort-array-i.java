class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);
        int count = 0;
        while (!isNonDecreasing(list)) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < min) {
                    min = sum;
                    idx = i;
                }
            }
            list.remove(idx);      
            list.remove(idx);      
            list.add(idx,min); 
            count++;
        }
        return count;
    }
    public boolean isNonDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) return false;
        }
        return true;
    }
}
