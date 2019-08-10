public class d47_56_merge_intervals {
    /** Time: O(nlogn)
     * Space: O(n^2) */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
