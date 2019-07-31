public class d37_1055_shortest_way_to_form_string {
    /** Time: O(n^2)
     * Space: O(n) */
    public int shortestWay(String source, String target) {
        int[] arr = new int[26];
        for (char c: source.toCharArray()) {
            arr[c - 'a']++;
        }

        for (char c: target.toCharArray()) {
            if (arr[c - 'a'] == 0) return -1;
        }

        int count = 0;
        int i = 0;
        int j = 0;

        while (j < target.length()) {
            while (j < target.length() && i < source.length()) {
                if (target.charAt(j) == source.charAt(i)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            i = 0;
            count++;
        }
        return count;
    }
}
