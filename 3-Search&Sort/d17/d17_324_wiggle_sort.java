public class d17_324_wiggle_sort {

    /** Reference: https://www.cnblogs.com/grandyang/p/5139057.html
     * 我们可以先给数组排序，然后在做调整。调整的方法是找到数组的中间的数，相当于把有序数组从中间分成两部分，
     * 然后从前半段的末尾取一个，在从后半的末尾去一个，这样保证了第一个数小于第二个数，然后从前半段取倒数第二个，
     * 从后半段取倒数第二个，这保证了第二个数大于第三个数，且第三个数小于第四个数，以此类推直至都取完 */

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        Arrays.sort(nums);
        int n = nums.length;
        int[] temp = new int[n];

        int left = (n - 1) / 2;
        int right = n - 1;

        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                temp[i] = nums[left];
                left--;
            } else {
                temp[i] = nums[right];
                right--;
            }
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }
}
