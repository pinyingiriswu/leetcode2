import java.util.HashSet;
import java.util.Map;

public class d41_159_longest_substring_with_at_most_two_distinct_characters {
    /** Time: O(n)
     * Space: O(n) */
    //method 1
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashSet<Character> set = new HashSet();
        int[] pos = new int[128]; // track position of rightmost character
        int maxLen = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            set.add(s.charAt(right));
            pos[s.charAt(right)] = right++; // record rightmost position for the character
            while (left < right && set.size() > 2) { // distinct character count exceeds 2
                if (left == pos[s.charAt(left)]) { // if left is the rightmost position for s.charAt(left), remove it so that distinct number between left and right is 2
                    set.remove(s.charAt(left));
                }
                left++; //move left index to next position
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    //method 2
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char cur = s.charAt(right);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.size() > 2) {
                char prev = s.charAt(left++);
                map.replace(prev, map.get(prev) - 1);
                map.remove(prev, 0);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
