public class d38_845_longest_mountain_in_array {
    /** Time: O(n)
     * Space: O(1) */
    public int longestMountain(int[] A) {
        int res = 0;
        for (int i = 1; i < A.length;) {
            if (A[i - 1] < A[i]) {
                int j = i;

                //go up
                while (j < A.length && A[j - 1] < A[j]) {
                    j++;
                }
                if (j == A.length) break;

                //flat, duplicate numbers
                if (A[j - 1] == A[j]) {
                    i = j + 1;
                    continue;
                }

                // go down
                while (j < A.length && A[j - 1] > A[j]) {
                    j++;
                }
                if (j - i > 1) {
                    res = Math.max(res, j - i + 1);
                }

                i = j;
            } else {
                i++;
            }
        }
        return res;
    }
}
