public class d29_53_maximum_subarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] table = new int[n+1];

        table[0] = nums[0];
        int maxVal = table[0];

        for (int i = 1; i < n; i++) {
            table[i] = Math.max(nums[i], nums[i] + table[i-1]);
            maxVal = Math.max(maxVal, table[i]);
        }
        return maxVal;
    }
}
