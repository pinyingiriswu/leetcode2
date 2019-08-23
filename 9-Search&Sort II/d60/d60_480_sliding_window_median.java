import java.util.Collections;

public class d60_480_sliding_window_median {
    /** Time: O(n^2)
     * Space: O(n)*/
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];
        // stores smaller half than median
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // stores larger half than median
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        double temp = 0.0;
        for (int i = 0; i < n; i++) {
            maxHeap.offer(nums[i]);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            if (maxHeap.size() + minHeap.size() == k) {
                if (maxHeap.size() == minHeap.size()) {
                    temp = (double) ((long)maxHeap.peek() + (long)minHeap.peek()) / 2;
                } else {
                    temp = maxHeap.peek();
                }
                int pos = i - k + 1;
                res[pos]= temp;
                if (!maxHeap.remove(nums[pos])) {
                    minHeap.remove(nums[pos]);
                }
            }
        }
        return res;
    }
}
