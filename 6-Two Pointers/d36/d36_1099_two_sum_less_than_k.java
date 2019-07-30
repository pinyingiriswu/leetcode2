public class d36_1099_two_sum_less_than_k {
    /** Time: O(n)
     * Space: O(1) */
    public int twoSumLessThanK(int[] A, int K) {
        if (A.length == 0) return -1;
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        int S = -1;

        while (i < j) {
            int sum = A[i] + A[j];
            if (sum >= K) {
                j--;
            } else {
                S = Math.max(S, sum);
                i++;
            }
        }

        return S;
    }
}
