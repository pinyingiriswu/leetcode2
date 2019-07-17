public class d23_79_word_search {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word == null) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int pos) {
        if (pos == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(pos)) return false;

        char c = board[row][col];
        board[row][col] = '#'; //already processed

        // find at least one path that matches the word
        boolean res = dfs(board, word, row - 1, col, pos + 1) ||
                dfs(board, word, row, col - 1, pos + 1) ||
                dfs(board, word, row + 1, col, pos + 1) ||
                dfs(board, word, row, col + 1, pos + 1);
        board[row][col] = c; //resume for backtracking
        return res;
    }
}
