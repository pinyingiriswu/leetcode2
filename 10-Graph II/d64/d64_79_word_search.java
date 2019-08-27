public class d64_79_word_search {
    /** Time: O(m*n)
     * Space: O(1)
     * */
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int pos) {
        if (pos == word.length()) return true;
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || board[row][col] != word.charAt(pos)) return false;

        char c = board[row][col];
        board[row][col] = '#'; // visited

        boolean res = dfs(board, row - 1, col, word, pos + 1) ||
                dfs(board, row + 1, col, word, pos + 1) ||
                dfs(board, row, col - 1, word, pos + 1) ||
                dfs(board, row, col + 1, word, pos + 1);

        board[row][col] = c; // resume for backtracking
        return res;
    }
}
