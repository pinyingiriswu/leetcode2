public class d38_560_subarray_sum_equals_k {
    /** Time: O(n)
     * Space: O(n) */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //use hash table to record sum and occurrences

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            }
        }
        return count;
    }
}
