class Solution {
    public int lastStoneWeight(int[] stones) {

        List<Integer> list = new ArrayList<>();

        for (int stone : stones) {
            list.add(stone);
        }

        while (list.size() > 1) {

            int m1 = Collections.max(list);
            list.remove(Integer.valueOf(m1));

            int m2 = Collections.max(list);
            list.remove(Integer.valueOf(m2));

            if (m1 != m2) {
                list.add(m1 - m2);
            }
        }

        return list.isEmpty() ? 0 : list.get(0);
    }
}