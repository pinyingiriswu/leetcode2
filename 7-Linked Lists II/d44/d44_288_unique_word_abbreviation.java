import java.util.Map;
import java.util.Set;

public class d44_288_unique_word_abbreviation {

    class ValidWordAbbr {
        private Map<String, Boolean> abbrDict = new HashMap<>();
        private Set<String> dict;

        public ValidWordAbbr(String[] dictionary) {
            dict = new HashSet<>(Arrays.asList(dictionary));
            for (String s: dict) {
                String abbr = toAbbr(s);
                abbrDict.put(abbr, !abbrDict.containsKey(abbr));
            }
        }

        public boolean isUnique(String word) {
            String abbr = toAbbr(word);
            Boolean hasAbbr = abbrDict.get(abbr);
            return hasAbbr == null || (hasAbbr && dict.contains(word));
        }

        private String toAbbr(String s) {
            int n = s.length();
            if (n <= 2) return s;
            return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
        }
    }

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */

}
