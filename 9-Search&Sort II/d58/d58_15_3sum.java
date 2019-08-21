public class d58_15_3sum {
    /** Time: O(n^2)
     * Space: O(n)*/
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip duplicates
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp < 0) {
                    j++;
                }
                if (temp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    //skip duplicates
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    //skip duplicates
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }

                if (temp > 0) {
                    k--;
                }

            }
        }
        return res;
    }
}
