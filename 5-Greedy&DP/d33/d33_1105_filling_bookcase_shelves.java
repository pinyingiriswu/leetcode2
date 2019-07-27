public class d33_1105_filling_bookcase_shelves {
    /** Time: O(n^2)
     * Space: O(n) */
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;

        // dp[i]: min height for i books
        int[] dp = new int[n + 1];

        // if 0 books added, min height is 0
        dp[0] = 0;

        // start adding books, 1 is one book added, which is from index 0
        for (int i = 1; i <= n; i++) {
            int width = 0;
            int height = 0;

            // add current book to top of the shelf
            dp[i] = dp[i-1] + books[i-1][1];

            // start taking previous books and move them to current shelf
            // maybe the shelf height will drop
            for (int j = i - 1; j >= 0; j--) {
                width += books[j][0];

                // new current shelf height is the max of previous height and the last book added
                height = Math.max(height, books[j][1]);
                if (width <= shelf_width) {

                    // the new min possible height is either the previous height
                    // or the height we have after removing book j from previous shelf
                    // plus the height of the current (newly created for ith book) shelf
                    dp[i] = Math.min(dp[i], dp[j] + height);
                } else {
                    break;
                }
            }
        }

        // return the best possible min height after adding the last ith book
        return dp[n];
    }
}
