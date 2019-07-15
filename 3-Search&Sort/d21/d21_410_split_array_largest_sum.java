public class d21_410_split_array_largest_sum {

    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            // left is maximum number in nums array
            left = Math.max(left, nums[i]);
            // right is sum of nums array
            right += nums[i];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, m, mid)) right = mid;
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    // check if we can split array with total <= sum
    private boolean check(int[] nums, int m, int sum) {
        int count = 1, curSum = 0;
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
