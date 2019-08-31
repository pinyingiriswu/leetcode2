public class d68_959_regions_cut_by_slashes {
    private int N;
    private int count;
    private int[] parents;

    public int regionsBySlashes(String[] grid) {
        /** Time: O(n^3)
         * Space: O(n^2)
         * */
        N = grid.length;
        count = N * N * 4; // each 1*1 square is split into 4 regions, total region is N*N*4
        parents = new int[count];
        for (int i = 0; i < count; i++) {
            parents[i] = i;
        }

        // 1 * 1 square split into 4 regions:
        //     -----------
        //     |  \ 0 /  |
        //     | 3 \ / 1 |
        //     |   / \   |
        //     |  / 2 \  |
        //     -----------
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char c = grid[i].charAt(j);
                if (c != '\\') {
                    union(getIndex(i, j, 0), getIndex(i, j, 3));
                    union(getIndex(i, j, 1), getIndex(i, j, 2));
                }
                if (c != '/') {
                    union(getIndex(i, j, 0), getIndex(i, j, 1));
                    union(getIndex(i, j, 2), getIndex(i, j, 3));
                }

                // connecting up and down section between regions
                if (i > 0) {
                    union(getIndex(i - 1, j, 2), getIndex(i, j, 0));
                }
                // connecting left and right section between regions
                if (j > 0) {
                    union(getIndex(i, j - 1, 1), getIndex(i, j, 3));
                }
            }
        }
        return count;
    }

    private int getIndex(int x, int j, int z) {
        // root: (x * N + j)
        return (x * N + j) * 4 + z;
    }

    private int find(int i) {
        if (parents[i] == i) {
            return i;
        }
        return find(parents[i]);
    }

    private void union(int u1, int u2) {
        int p1 = find(u1);
        int p2 = find(u2);
        if (p1 == p2) {
            return;
        }
        if (p1 <= p2) {
            parents[p1] = p2;
        } else {
            parents[p2] = p1;
        }
        count--;
    }
}
