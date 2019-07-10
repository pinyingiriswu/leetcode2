public class d16_215_kth_largest_element_in_an_array {

    /** Use Quick Select */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) return 0;
        return getKth(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    // function for getting kth smallest number, k = nums.length - k + 1 to get kth largest number
    public int getKth(int[] nums, int left, int right, int k) {

        int pivot = nums[right];
        int pivotPos = left;
        int temp = -1;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                temp = nums[i];
                nums[i] = nums[pivotPos];
                nums[pivotPos] = temp;
                pivotPos++;
            }
        }

        nums[right] = nums[pivotPos];
        nums[pivotPos] = pivot;

        // to be the kth smallest number, there must be k-1 smaller ones
        if (pivotPos - left == k - 1) {
            return nums[pivotPos];
        }
        else if (pivotPos - left > k - 1) {
            return getKth(nums, left, pivotPos - 1, k);
        } else {
            return getKth(nums, pivotPos + 1, right, k - pivotPos + left - 1);
        }
    }

    /** Use Heap */
    public int findKthLargest(int[] nums, int k) {

        int res = -1;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        for (int n: nums) {
            pq.offer(n);
        }

        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }

        return res;
    }
}
