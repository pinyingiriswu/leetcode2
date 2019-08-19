public class d56_340_longest_substring_with_at_most_k_distinct_characters {
    /** Time: O(n)
     * Space: O(n) */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] arr = new int[256];
        int count = 0, left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            int charRight = s.charAt(right);

            // for character at right, count the frequency when it is only 0
            if (arr[charRight] == 0) {
                count++;
            }
            arr[charRight]++;

            // slide by removing the left character from the window
            while(count > k) {
                int charLeft = s.charAt(left);
                arr[charLeft]--;

                // decrease the number of count when frequency is back to 0
                if (arr[charLeft] == 0) {
                    count--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
