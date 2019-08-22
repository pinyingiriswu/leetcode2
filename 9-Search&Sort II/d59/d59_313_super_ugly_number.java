public class d59_313_super_ugly_number {
    /** Time: O(n^2)
     * Space: O(n)*/
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1l); // adding long 1, 1l = (long) 1

        for (int i = 1; i < n; i++) {
            long temp = pq.poll();
            for (int prime: primes) {
                pq.offer(temp * prime);
            }
            while (temp == pq.peek()) {
                pq.poll();
            }
        }

        return pq.poll().intValue();
    }
}
