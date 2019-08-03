public class d40_862_shortest_subarray_with_sum_at_least_k {
    /** Time: O(n)
     * Space: O(n) */
    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
        }

        int res = n + 1; // n + 1 is impossible
        Deque<Integer> dq = new LinkedList();
        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && preSum[i] <= preSum[dq.getLast()]) {
                dq.pollLast();
            }
            while (!dq.isEmpty() && preSum[i] - preSum[dq.getFirst()] >= K) {
                res = Math.min(res, i - dq.pollFirst());
            }
            dq.addLast(i);
        }

        return res == n + 1? -1: res;
    }
}
