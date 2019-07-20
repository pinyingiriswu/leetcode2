public class d26_787_cheapest_flights_within_k_stops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] f: flights) {
            if (!map.containsKey(f[0])) {
                map.put(f[0], new HashMap<>());
            }
            map.get(f[0]).put(f[1], f[2]);
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[] {0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> adj = map.getOrDefault(city, new HashMap<>());
                for (int k: adj.keySet()) {
                    pq.add(new int[] {price + adj.get(k), k, stops - 1});
                }
            }
        }
        return -1;
    }
}
