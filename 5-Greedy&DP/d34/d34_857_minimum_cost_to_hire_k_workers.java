public class d34_857_minimum_cost_to_hire_k_workers {
    /** Time: O(nlogn)
     * Space: O(n) */
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));
        int n = wage.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new double[] {(double) wage[i]/quality[i], (double) quality[i]});
        }
        PriorityQueue<Double> amount = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double sum = 0;
        double res = Double.MAX_VALUE;
        while (!pq.isEmpty()) {
            double[] temp = pq.poll();
            sum += temp[1];
            amount.offer(temp[1]);
            if (amount.size() > K) sum -= amount.poll();
            if (amount.size() == K) res = Math.min(res, temp[0] * sum);
        }
        return res;
    }
}
