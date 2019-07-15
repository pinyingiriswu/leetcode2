public class d21_300_longest_increasing_subsequence {

    /** Binary Search */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int n: nums) {
            if (n < list.get(0)) {
                list.set(0, n);
            } else if (n > list.get(list.size() - 1)) {
                list.add(n);
            } else {
                int left = 0, right = list.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (list.get(mid) < n) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, n);
            }
        }
        return list.size();
    }

    /** DP */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int i, j, max = 0;

        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }
}
