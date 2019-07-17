public class d23_529_minesweeper {
    int[][] dirs = {{-1, -1}, {-1, 1}, {0, -1}, {0, 1}, {-1, 0}, {1, 0}, {1, -1}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0) return board;
        int m = board.length;
        int n = board[0].length;
        int row = click[0];
        int col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            dfs(board, row, col);
        }
        return board;
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row > board.length-1 || col < 0 || col > board[0].length - 1 || board[row][col] != 'E') return;

        int mines = 0;

        for (int[] dir: dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && x <= board.length-1 && y >= 0 && y <= board[0].length - 1 && board[x][y] == 'M') {
                mines++;
            }
        }

        // if revealed is blank space, we need to update the board recursively
        if (mines == 0) {
            board[row][col] = 'B';
            for (int[] dir: dirs) {
                dfs(board, row + dir[0], col + dir[1]);
            }
        } else {
            // if revealed square has mines nearby, update the number of mines in this square and return
            board[row][col] = (char)(mines + '0');
            return;
        }
    }
}
