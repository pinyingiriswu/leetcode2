public class d37_523_continuous_subarray_sum {
    /** Time: O(n)
     * Space: O(n) */

    /*
    (reference: https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/congruence-modulo)
    if the results of two integers i1 and i2 modulo k are the same, then we can say they are in the same group
    e.g. 7 % 13 = 7 and 46 % 13 = 7, so we can think of 7 and 46 are in the same group
    we can name the group using the result of modulo
    if we know two integers i1 and i2 are in the same group d, then we have:
    i1 = 13 * a + d and i2 = 13 * b + d where a and b are both integers
    if then we calculate their difference, we can get:
    i1 - i2 = 13 * a - 13 * b + d - d = 13 * (a - b)
    since a and b are both integers, (a - b) must be integers as well
    Conclusion: if two integers are in the same group, their difference must be divisible by the divisor k
    Now back to prefix sum, if we know that the difference of two prefix sum is divisible by k, then we
    can learn that sum of the subarray corresponds to this difference must be divisible by k (aka, it is
    multiple of k
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // (sum, index)

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
