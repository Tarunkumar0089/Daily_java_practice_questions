class Solution {
    public int countTriples(int n) {
        int count = 0;
        Set<Integer> squares = new HashSet<>();
        for (int c = 1; c <= n; c++){
         squares.add(c * c);
        }
        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                int sum = a * a + b * b;
                if (squares.contains(sum)) {
                    if (a == b) count += 1;
                    else count += 2;
                }
            }
        }
        return count;
    }
}
