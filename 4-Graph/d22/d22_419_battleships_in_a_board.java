public class d22_419_battleships_in_a_board {

    public int countBattleships(char[][] board) {
        //Observe the most top-left ship.
        //In other words, if the 'X' has no other 'X' on top of or left to it, this is the head of the battleship.
        // Count the numbers of the top-left corners.

        int m = board.length;
        int n = board[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                count++;
            }
        }
        return count;
    }
}
