public class d36_26_remove_duplicates_from_sorted_array {
    /** Time: O(n)
     * Space: O(1) */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }

        return i + 1;
    }
}
