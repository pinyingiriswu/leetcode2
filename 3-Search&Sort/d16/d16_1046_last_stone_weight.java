public class d16_1046_last_stone_weight {

    public int lastStoneWeight(int[] stones) {

        //max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int stone: stones) {
            pq.offer(stone);
        }

        while (pq.size() != 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            int newStone = Math.abs(s1 - s2);
            pq.offer(newStone);
        }

        return pq.peek();
    }
}
