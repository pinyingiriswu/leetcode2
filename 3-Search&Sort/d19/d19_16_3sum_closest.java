public class d19_16_3sum_closest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; //skip duplicates
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];

                if (Math.abs(temp - target) < Math.abs(res - target)) {
                    res = temp;
                }

                if (temp < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return res;
    }
}
