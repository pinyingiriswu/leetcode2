public class d42_1074_number_of_submatrices_that_sum_to_target {
    /** Time: O(n^3)
     * Space: O(n^2) */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // calculate prefix sum for each row
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        int count = 0;

        // for every possible range between two columns, accumulate the prefix sum of submatrices that can be formed between these two columns by adding up the sum of values between these two columns for every row
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // key of this hashmap present the unique value of all possible prefix sum that we've seen so far
                // value of this hashmap represents the count (number of appearances) of each prefix sum value we've seen so far
                // an empty submatrix trivially has a sum of 0
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int cur = 0;

                // Assume i = 1, j = 3. Here we are actually calculating the prefix sum of submatrices which has column 1, 2, and 3, by adding up the sum of matrix[0][1...3], matrix[1][1...3] ... matrix[m-1][1...3] row by row, starting from the first row (row 0).
                for (int k = 0; k < m; k++) {
                    cur += matrix[k][j] - (i > 0 ? matrix[k][i - 1]: 0);
                    count += map.getOrDefault(cur - target, 0);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return count;
    }
}
