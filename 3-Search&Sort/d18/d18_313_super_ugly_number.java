public class d18_313_super_ugly_number {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue();

        pq.offer(1l); //adding long 1 instead of int 1, 1l = (long)1

        for (int i = 1; i < n; i++) {
            long temp = pq.poll();

            for (long prime: primes) {
                pq.offer(temp * prime);
            }

            while (temp == pq.peek()) {
                pq.poll();
            }
        }

        return pq.poll().intValue();
    }

}
