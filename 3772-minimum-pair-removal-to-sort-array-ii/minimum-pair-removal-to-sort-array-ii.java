class Solution {
  static class Pair {
        long sum;
        int left;
        Pair(long s, int l) {
            sum = s;
            left = l;
        }
    }
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nums[i];

        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
            alive[i] = true;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> x.sum == y.sum ? x.left - y.left : Long.compare(x.sum, y.sum)
        );

        int bad = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) bad++;
        }

        for (int i = 0; i + 1 < n; i++) {
            pq.offer(new Pair(a[i] + a[i + 1], i));
        }

        int ops = 0;

        while (bad > 0) {
            Pair p = pq.poll();
            int i = p.left;
            int j = next[i];
            if (j >= n || !alive[i] || !alive[j]) continue;
            if (a[i] + a[j] != p.sum) continue;

            int pi = prev[i];
            int nj = next[j];
            if (pi != -1 && a[i] < a[pi]) bad--;
            if (nj < n && a[nj] < a[j]) bad--;
            if (a[j] < a[i]) bad--;
            a[i] += a[j];
            alive[j] = false;
            next[i] = nj;
            if (nj < n) prev[nj] = i;
            if (pi != -1 && a[i] < a[pi]) bad++;
            if (nj < n && a[nj] < a[i]) bad++;
            if (pi != -1) pq.offer(new Pair(a[pi] + a[i], pi));
            if (nj < n) pq.offer(new Pair(a[i] + a[nj], i));
            ops++;
        }

        return ops;
    }
}
