public class d68_815_bus_routes {
    /** Time: O(n^2)
     * Space: O(n)
     * */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); //track bus stops and its buses
        int res = 0;

        if (S == T) return 0;

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }

        q.offer(S);
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                int top = q.poll();
                ArrayList<Integer> buses = map.get(top);
                for (int bus: buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return res;
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}
