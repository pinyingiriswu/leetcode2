public class d41_239_sliding_window_maximum {
    // method 1:
    /** Time: O(n^2)
     * Space: O(n) */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        int n = nums.length - k + 1;
        int[] res = new int[n];
        int i = 0;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length; j++) {
            if (j - i == k - 1) {
                for (int p = i; p <= j; p++) {
                    max = Math.max(max, nums[p]);
                }
                res[i] = max;
                i++;
                max = Integer.MIN_VALUE;
            }
        }
        return res;
    }

    //method 2: using deque
    /** Time: O(n)
     * Space: O(n) */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length - k + 1;
        int[] res = new int[n];
        int index = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        // sliding window
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[dq.peekFirst()] < nums[i]) {
                dq.removeFirst(); // remove smallest element than current element
            }
            dq.addFirst(i); // add newest element
            if (i - dq.peekLast() >= k) {
                dq.removeLast(); // remove leaking element
            }
            if (i >= k - 1) {
                res[index++] = nums[dq.peekLast()]; // retrieve largest element in window
            }
        }
        return res;
    }
}

