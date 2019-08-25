public class d62_4_median_of_two_sorted_arrays {
    /** Time: O(log(m + n))
     * Space: O(1)*/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, total / 2) +
                    findKth(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, 0, nums2, 0, total / 2 + 1);
        }
    }

    // k is not index, k >= 1
    private double findKth(int[] nums1, int index1, int[] nums2, int index2, int k) {
        // nums1 is empty
        if (index1 >= nums1.length) {
            return nums2[index2 + k - 1];
        }

        // nums2 is empty
        if (index2 >= nums2.length) {
            return nums1[index1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }

        int key1 = Integer.MAX_VALUE;
        int key2 = Integer.MAX_VALUE;

        if (index1 + k/2 - 1 < nums1.length) {
            key1 = nums1[index1 + k/2 - 1];
        }

        if (index2 + k/2 - 1 < nums2.length) {
            key2 = nums2[index2 + k/2 - 1];
        }

        if (key1 < key2) {
            return findKth(nums1, index1 + k/2, nums2, index2, k - k/2);
        } else {
            return findKth(nums1, index1, nums2, index2 + k/2, k - k/2);
        }
    }
}
