public class d65_1101_the_earliest_moment_when_everyone_becomes_friends {
    /** Time: O(nlogn) --> sorting
     * Space: O(n)
     * */
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]); // increasing order
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int count = N;  // everyone is its own parent at the beginning

        for (int[] log: logs) {
            int p1 = findParent(parent, log[1]);
            int p2 = findParent(parent, log[2]);
            if (p1 != p2) {
                count--;
                parent[p1] = p2;
                // when count == 1, there's only 1 parent that everyone has
                if (count == 1) return log[0];
            }
        }
        return -1;
    }

    private int findParent(int[] parent, int index) {
        if (parent[index] == index) {
            return index;
        }
        return findParent(parent, parent[index]);
    }
}
