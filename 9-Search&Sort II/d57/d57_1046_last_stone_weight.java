public class d57_1046_last_stone_weight {
    /** Time: O(nlogn)
     * Space: O(n)*/
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); //max heap

        for (int stone: stones) {
            pq.offer(stone);
        }

        while(pq.size() != 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            int newStone = Math.abs(s1 - s2);
            pq.offer(newStone);
        }

        return pq.peek();
    }
}
