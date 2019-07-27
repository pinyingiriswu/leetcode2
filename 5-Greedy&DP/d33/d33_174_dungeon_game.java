public class d33_174_dungeon_game {
    /** Time: O(n^2)
     * Space: O(n^2) */
    public int calculateMinimumHP(int[][] dungeon) {
        /** Formula:
         * dp[i][j] = max(min(dp[i+1][j],dp[i][j])-dungeon[i][j]],1)
         * */
        int m = dungeon.length; //row
        int n = dungeon[0].length; //column

        dungeon[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);

        //init last row
        for (int i = n-2; i >= 0; i--) {
            dungeon[m-1][i] = Math.max(dungeon[m-1][i+1] - dungeon[m-1][i], 1);
        }

        //init last col
        for (int i = m-2; i >= 0; i--) {
            dungeon[i][n-1] = Math.max(dungeon[i+1][n-1] - dungeon[i][n-1], 1);
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dungeon[i][j] = Math.max(Math.min(dungeon[i+1][j], dungeon[i][j+1]) - dungeon[i][j], 1);
            }
        }
        return dungeon[0][0];
    }
}
