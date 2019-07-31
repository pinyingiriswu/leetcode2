public class d37_325_maximum_size_subarray_sum_equals_k {
    /** Time: O(n)
     * Space: O(n) */

    /** Reference: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/261998/JAVA-solution-with-explanation

        This question builds on top of range sum question where sum(currentIndex) - sum(previousIndex) = k
        sum(currentIndex) - k = sum(previousIndex), since we store sum until index i as key in our map we just need to check
        if our map contains sum(previousIndex) which is sum(currentIndex) - k if yes we get the length from the previousIndex to
        the current index if that length is greater than the max length we set the max to that
     */

    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // The step below is done because when we do array calculations we start from index 0
        // but when we want the result we want it to start from index 1
        // Example case would be [0,0,0,1] with k = 1, the answer would be 4 however the array index would be from 0 to 3
        // So we add an arbitrary value in our map to account for adding one to our final answer
        map.put(0, -1); //(sum, index)

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                res = Math.max(res, len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return res;
    }
}
