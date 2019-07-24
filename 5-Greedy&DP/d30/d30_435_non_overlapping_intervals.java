public class d30_435_non_overlapping_intervals {
    /** Time: O(nlogn)
     * Space: O(1) */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                // sort by start time in ascending order, then by end time in ascending order
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                else {
                    return a[0] - b[0];
                }
            }
        });
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
