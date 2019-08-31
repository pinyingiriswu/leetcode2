public class d68_1066_campus_bikes_ii {
    /** Time: O(n^2)
     * Space: O(n)
     * */

    int res = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] taken = new boolean[bikes.length];
        dfs(workers, bikes, 0, taken, 0);
        return res;
    }

    private void dfs(int[][] workers, int[][] bikes, int index, boolean[] taken, int sum) {
        if (index == workers.length) {
            res = Math.min(res, sum);
            return;
        }
        int[] worker = workers[index];
        for (int i = 0; i < bikes.length; i++) {
            int[] bike = bikes[i];
            if (!taken[i]) {
                taken[i] = true;
                dfs(workers, bikes, index + 1, taken, sum + calcDist(worker, bike));
                taken[i] = false; // backtrack
            }
        }
    }

    private int calcDist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
