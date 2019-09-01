public class d69_854_k_similar_strings {
    /** Time: O(n^2)
     * Space: O(n)
     * */
    public int kSimilarity(String A, String B) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        q.offer(A);
        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if(cur.equals(B)) return res;
                int p = 0;
                while (cur.charAt(p) == B.charAt(p)) p++;
                for (int j = p + 1; j < cur.length(); j++) {
                    if (cur.charAt(j) != B.charAt(p) || cur.charAt(j) == B.charAt(j)) continue;
                    String next = swap(cur, p, j);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private String swap(String cur, int p, int j) {
        char[] input = cur.toCharArray();
        char temp = input[p];
        input[p] = input[j];
        input[j] = temp;
        return new String(input);
    }
}
