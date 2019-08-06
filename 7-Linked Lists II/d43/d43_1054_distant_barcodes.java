import java.util.Map;
import java.util.PriorityQueue;

public class d43_1054_distant_barcodes {
    /** Time: O(nlogn)
     * Space: O(n) */
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();

        // Hashmap entry: (number, its occurrences)
        for (int b: barcodes) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        // Pop out the number with most occurrences, if the occurrences are the same, pop the smaller number
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue() == 0 ? a.getKey() - b.getKey(): b.getValue() - a.getValue();
        });

        // push map entry into priority queue
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }

        int[] res = new int[barcodes.length];
        int idx = 0;
        Map.Entry<Integer, Integer> prev = null;

        while (idx < barcodes.length) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            res[idx++] = entry.getKey();
            // update the occurrences of the popped-out number
            entry.setValue(entry.getValue() - 1);
            // push the updated entry into the priority queue
            if (prev != null && prev.getValue() >= 1) {
                pq.offer(prev);
            }
            // prev = updated entry
            prev = entry;
        }
        return res;
    }
}
