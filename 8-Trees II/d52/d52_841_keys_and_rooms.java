public class d52_841_keys_and_rooms {
    /** DFS */
    /** Time: O(n)
     * Space: O(n) */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] canVisit = new boolean[rooms.size()];
        canVisit[0] = true;
        dfs(0, rooms, canVisit);

        for (int i = 0; i < canVisit.length; i++) {
            if (!canVisit[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int i, List<List<Integer>> rooms, boolean[] canVisit) {
        List<Integer> keys = rooms.get(i);
        if (i == rooms.size()) return;
        if (keys == null || keys.size() == 0) return;
        for (int key: keys) {
            if (!canVisit[key]) {
                canVisit[key] = true;
                dfs(key, rooms, canVisit);
            }
        }
    }

    /** BFS */
    /** Time: O(n)
     * Space: O(n) */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] canVisit = new boolean[rooms.size()];
        canVisit[0] = true;
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while(!q.isEmpty()) {
            int n = q.poll();
            canVisit[n] = true;
            List<Integer> keys = rooms.get(n);
            for (int key: keys) {
                if (!canVisit[key]) {
                    canVisit[key] = true;
                    q.add(key);
                }
            }
        }


        for (int i = 0; i < rooms.size(); i++) {
            if (!canVisit[i]) {
                return false;
            }
        }
        return true;
    }
}
