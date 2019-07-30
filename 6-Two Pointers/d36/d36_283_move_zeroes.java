public class d36_283_move_zeroes {
    /** Time: O(n)
     * Space: O(1) */
    public void moveZeroes(int[] nums) {
        int m = 0; //track zeroes
        for (int num: nums) {
            if (num != 0) {
                nums[m++] = num;
            }
        }

        while (m < nums.length) {
            nums[m++] = 0;
        }
    }
}
