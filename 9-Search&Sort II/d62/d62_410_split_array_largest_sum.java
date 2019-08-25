public class d62_410_split_array_largest_sum {
    /** Time: O(nlog(sumOfArray - maxElementInArray))
     * Space: O(1)*/
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            // left is largest number in the array
            left = Math.max(left, nums[i]);
            // right is the sum of the array
            right += nums[i];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int m, int sum) {
        int count = 1;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > sum) {
                curSum = nums[i];
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }
}
