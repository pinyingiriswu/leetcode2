public class d34_140_word_break_ii {
    /** Time: O(n^2)
     * Space: O(n) */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> dict = new HashSet<>();
        for (String w: wordDict) {
            dict.add(w);
        }
        return helper(s, dict, map);
    }

    private List<String> helper(String s, Set<String> dict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<>();
        if (dict.contains(s)) {
            res.add(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            String pre = s.substring(0, i);
            if (!dict.contains(pre)) {
                continue;
            }
            List<String> list =  helper(s.substring(i, s.length()), dict, map);
            for (String next: list) {
                res.add(pre + " " + next);
            }
        }
        map.put(s, res);
        return res;
    }
}
