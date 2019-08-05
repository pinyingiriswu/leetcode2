public class d42_632_smallest_range {
    /** Time: O(nlogn)
     * Space: O(n) */
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int left = 0;
        int right = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        Map<Integer, Iterator<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.put(i, nums.get(i).iterator());
            int val = map.get(i).next();
            maxVal = Math.max(maxVal, val);
            pq.offer(new int[]{i, val});
        }
        while (pq.size() == nums.size()) {
            int[] top = pq.poll();
            int i = top[0], val = top[1];
            if (maxVal - val < right - left) {
                left = val;
                right = maxVal;
            }
            if (map.get(i).hasNext()) {
                int next = map.get(i).next();
                maxVal = Math.max(maxVal, next);
                pq.offer(new int[] {i, next});
            }
        }
        return new int[] {left, right};
    }
}
