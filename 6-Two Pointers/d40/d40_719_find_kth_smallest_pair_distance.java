public class d40_719_find_kth_smallest_pair_distance {
    /** Time: O(nlogn)
     * Space: O(n) */
    public int smallestDistancePair(int[] nums, int k) {
        // Idea:
        // Compute the distance and count the number of pairs with distance less than or equal to my guess,
        // and then compare the count with k, then adjust the left and right, until converge.
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];

        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = 0;
            int left = 0;
            for (int right = 0; right < n; right++) {
                while (nums[right] - nums[left] > mid) left++;
                count += right - left; // count is the number of pairs with distance <= mid
            }
            if (count >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
