import java.util.Map;
import java.util.TreeSet;

public class d42_727_minimum_window_subsequence {
    /** Time: O(STlogS)
     * Space: O(S) */
    /** Reference: https://leetcode.com/problems/minimum-window-subsequence/discuss/245290/Easy-Java-iterative-solution-with-explanation-no-dp */
    //    Use a hash map to store S’s character’s starting indices in a treeset, e.g. if S = “abcdebdde”
    //    i.e. [a,[0]] [b,[1,5]] [c[2]] [d[3,6,7]] [e,[4,8]]
    //    Then try to find the sequence one by one, in the case of T=“bde”, sequence is found as 1 to 4.
    //    The treeset().higher function makes sure the next character in T will be bigger than previous character of T found in S.
    //    In the end we check all the sequences and find the minimum one. i.e. another sequence is 5 to 8, but this does not reduce minimum distance so doesn’t count.
    public String minWindow(String S, String T) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();

        // initialize
        for (int i = 0; i < 26; i++) {
            map.put((char)(i + 'a'), new TreeSet<Integer>());
        }

        // create map for all characters and their corresponding indices in String S
        for (int i = 0; i < S.length(); i++) {
            map.get(S.charAt(i)).add(i);
        }
        int diff = Integer.MAX_VALUE;
        String res = "";

        // for all the occurrences of the first character in T
        for (int start: map.get(T.charAt(0))) {
            int end = getEndIndex(map, T, start-1);
            if (end != -1 && (diff > end - start)) {
                diff = end - start;
                res = S.substring(start, end + 1);
            }
        }
        return res;
    }

    private int getEndIndex(Map<Character, TreeSet<Integer>> map, String T, int start) {
        int firstEndIndex = 0;
        for (int i = 0; i < T.length(); i++) {
            Integer cur = map.get(T.charAt(i)).higher(start);
            if (cur == null) return -1;
            firstEndIndex = cur;
            start = firstEndIndex;
        }
        return firstEndIndex;
    }
}
