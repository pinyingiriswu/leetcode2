public class d46_76_minimum_window_substring {
    /** Time: O(n)
     * Space: O(n) */
    public String minWindow(String s, String t) {
        int start = 0, count = 0;
        String res = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) count++;
            }

            while (count == t.length()) {
                if (res.length() == 0 || i - start + 1 < res.length()) {
                    res = s.substring(start, i + 1);
                }
                c = s.charAt(start);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) count--;
                }
                start++;
            }
        }
        return res;
    }
}
