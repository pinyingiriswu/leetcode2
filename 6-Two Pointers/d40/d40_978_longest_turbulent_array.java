public class d40_978_longest_turbulent_array {
    /** Time: O(n)
     * Space: O(n) */
    public int maxTurbulenceSize(int[] A) {
        // basically, this largest subarray needs to have every two adjacent elements to not have equal values
        if (A == null || A.length == 0) return 0;
        int res = 0;
        int prev = 0;
        int[] arr = new int[A.length];

        for (int i = 0, j = 0; j < A.length; j++) {
            if (j == A.length - 1) {
                return Math.max(res, j - i + 1);
            }
            int comp = Integer.compare(A[j], A[j+1]);
            if (comp == 0) {
                res = Math.max(res, j - i + 1);
                i = j + 1;
            } else if (comp != -prev) {
                res = Math.max(res, j - i + 1);
                i= j;
            }
            prev = comp;
        }
        return res;
    }
}
