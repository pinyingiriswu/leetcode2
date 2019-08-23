public class d60_31_next_permutation {
    /** Time: O(n)
     * Space: O(1)*/
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;

        int i = nums.length - 1;

        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        if (i == 0) Arrays.sort(nums);
        else {
            int target = nums[i - 1];
            for (int j = nums.length - 1; j > i - 1; j--) {
                if (target < nums[j]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
        Arrays.sort(nums, i, nums.length);
    }
}
