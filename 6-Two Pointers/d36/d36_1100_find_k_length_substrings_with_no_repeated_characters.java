public class d36_1100_find_k_length_substrings_with_no_repeated_characters {
    /** Time: O(n^2)
     * Space: O(n) */
    public int numKLenSubstrNoRepeats(String S, int K) {
        int[] count = new int[26];
        int res = 0;

        for (int j = 0, i = 0; j < S.length(); j++) {
            char c = S.charAt(j);
            count[c - 'a']++;
            while (count[c - 'a'] > 1) {
                count[S.charAt(i++) - 'a']--;
            }
            if (j - i + 1 >= K) res++;
        }
        return res;
    }
}
