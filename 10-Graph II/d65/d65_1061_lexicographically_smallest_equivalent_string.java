public class d65_1061_lexicographically_smallest_equivalent_string {
    /** Time: O(n)
     * Space: O(n)
     * */
    public String smallestEquivalentString(String A, String B, String S) {
        char[] parents = new char[26];
        for (char i = 'a'; i <= 'z'; i++) {
            parents[i - 'a'] = i; // everyone is its own parents at the beginning
        }

        int n = A.length();

        for (int i = 0; i < n; i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            char p1 = findParent(parents, a);
            char p2 = findParent(parents, b);
            if (p1 != p2) {
                // need to put lexicographically smaller character as parent
                if (p1 < p2) parents[p2 - 'a'] = p1;
                else
                    parents[p1 - 'a'] = p2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c: S.toCharArray()) {
            sb.append(findParent(parents, c));
        }
        return sb.toString();
    }

    private char findParent(char[] parents, char c) {
        if (parents[c - 'a'] == c) {
            return c;
        }
        return findParent(parents, parents[c - 'a']);
    }
}
