public class d60_16_3sum_closest {
    /** Time: O(n^2)
     * Space: O(1)*/
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (Math.abs(temp - target) < Math.abs(res - target)) {
                    res = temp;
                }
                if (temp < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
