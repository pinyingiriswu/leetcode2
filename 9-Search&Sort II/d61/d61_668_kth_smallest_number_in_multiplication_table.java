public class d61_668_kth_smallest_number_in_multiplication_table {
    /** Time: O(m*log(m*n))
     * Space: O(1)*/
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = helper(m, n, mid);
            if (count >= k) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    private int helper(int m, int n, int num) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(num / i, n);
        }
        return count;
    }
}
