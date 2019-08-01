public class d38_826_most_profit_assigning_work {
    /** Time: O(nlogn)
     * Space: O(n) */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0); //(difficulty, profit)
        int max = 0;
        int res = 0;
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], 0), profit[i]));
        }

        for (int key: map.keySet()) {
            max = Math.max(max, map.get(key));
            map.put(key, max);
        }

        for (int i = 0; i < worker.length; i++) {
            res += map.floorEntry(worker[i]).getValue(); // map entry<key, value>
        }
        return res;
    }
}
