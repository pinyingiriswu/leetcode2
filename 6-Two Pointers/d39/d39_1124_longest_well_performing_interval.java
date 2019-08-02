public class d39_1124_longest_well_performing_interval {
    /** Time: O(n)
     * Space: O(n) */
    public int longestWPI(int[] hours) {
        if (hours == null || hours.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int len = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                sum += 1;
            } else {
                sum -= 1;
            }

            if (sum > 0) {
                len = i + 1;
            } else {
                if (map.containsKey(sum - 1)) {
                    len = Math.max(len, i - map.get(sum - 1));
                }
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }
}
