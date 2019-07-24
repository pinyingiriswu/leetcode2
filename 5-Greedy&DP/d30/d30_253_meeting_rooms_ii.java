public class d30_253_meeting_rooms_ii {
    /** Time: O(nlogn)
     * Space: O(n) => construct min-heap of n elements */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b)->(a[0] - b[0])); //sort by start time in ascending order
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[1] - b[1])); //pq has smallest end time
        for (int[] interval: intervals) {
            if (!pq.isEmpty()) {
                int[] tmp = pq.peek();
                if (tmp[1] <= interval[0]) {
                    pq.poll();
                }
            }
            pq.add(interval);
        }
        return pq.size();
    }
}
