public class d38_713_subarray_product_less_than_k {
    /** Time: O(n)
     * Space: O(1) */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        if (nums == null || nums.length == 0) return 0;
        int prod = 1;
        int res = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while (prod >= k) {
                prod /= nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
