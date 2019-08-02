public class d39_923_3sum_with_multiplicity {
    /** Time: O(n^2)
     * Space: O(1) */
    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        long res = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int j = i + 1;
            int k = A.length - 1;
            while (j < k) {
                if (A[i] + A[j] + A[k] < target) {
                    j++;
                } else if (A[i] + A[j] + A[k] > target) {
                    k--;
                } else {
                    int left = 1; // left: number of elements equal to A[j]
                    int right = 1; // right: number of elements equal to A[k]
                    while (j + left < k && A[j + left] == A[j]) {
                        left++;
                    }
                    while (j + left <= k - right && A[k - right] == A[k]) {
                        right++;
                    }
                    // if A[j] == A[k], then count is C(k - j + 1, 2)
                    // else the count is left * right
                    res += A[j] == A[k] ? (k - j + 1) * (k - j) / 2 : left * right;
                    j += left;
                    k -= right;
                }
            }
        }
        return (int) (res % 1_000_000_007);
    }
}
