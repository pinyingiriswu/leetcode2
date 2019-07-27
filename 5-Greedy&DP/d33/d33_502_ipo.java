public class d33_502_ipo {
    /** Time: O(nlogk)
     * Space: O(k) */
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> (Capital[a] - Capital[b]));

        int p = Profits.length;
        for (int i = 0; i < p; i++) {
            minHeap.add(i);
        }

        int capital = W;

        for (int i = 0; i < k; i++) {
            while (minHeap.size() > 0 && Capital[minHeap.peek()] <= capital) {
                maxHeap.add(Profits[minHeap.poll()]);
            }

            if (maxHeap.size() == 0) {
                return capital;
            } else {
                capital += maxHeap.poll();
            }
        }
        return capital;
    }
}
