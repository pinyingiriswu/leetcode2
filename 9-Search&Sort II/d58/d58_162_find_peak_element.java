public class d58_162_find_peak_element {
    /** Time: O(logn)
     * Space: O(1)*/
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if (nums[mid] > nums[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }
    }
}
