public class d47_986_interval_list_intersections {
    /** Time: O(m + n)
     * Space: O(m + n) => maximum size can be length of A plus B */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0) return new int[0][0];

        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length) {
            // checking the intersection of A[i] and B[i]
            // start: startpoint of intersection
            // end: endpoint of intersection
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if (start <= end) {
                res.add(new int[] {start, end});
            }

            // remove the interval with the smallest endpoint
            // so that we don't have to deal with it afterwards
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
