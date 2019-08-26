public class d63_76_minimum_window_substring {
    /** Time: O(S+T) --> S: length of s, T: length of t
     * Space: O(S+T)*/

    /**
     * Two main points here:
     *
     * 1. The hashmap can be used as the counter to record how many characters in T
     * that we still need.
     *
     * 2. A signal counter is used to record how many characters in T we have already got.
     * When count == T.length(), means the whole T is satisfied.*/

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        String res = "";
        int start = 0;
        int count = 0;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count++;
                }
            }
            while (count == t.length()) {
                if (res.length() == 0 || i - start + 1 < res.length()) {
                    res = s.substring(start, i + 1);
                }
                c = s.charAt(start);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) {
                        count--;
                    }
                }
                start++;
            }
        }
        return res;
    }
}
