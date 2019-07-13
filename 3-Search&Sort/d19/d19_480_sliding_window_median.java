public class d19_480_sliding_window_median {

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder()); // stores smaller half than median
        PriorityQueue<Integer> minHeap = new PriorityQueue(); // stores larger half than median

        double temp = 0.0;

        for (int i = 0; i < n; i++) {
            maxHeap.offer(nums[i]);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            if (maxHeap.size() + minHeap.size() == k) {
                if (maxHeap.size() == minHeap.size()) {
                    temp = (double)((long)maxHeap.peek() + (long)minHeap.peek()) / 2;
                } else {
                    temp = maxHeap.peek();
                }

                int pos = i - k + 1;
                res[pos] = temp;
                if (!maxHeap.remove(nums[pos])) {
                    minHeap.remove(nums[pos]);
                }
            }
        }
        return res;
    }
}
