public class d69_51_n_queens {
    /** Time: O(n * n!) --> for each column, we check if Queen from different column can attack the given row
     * Space: O(n^2)
     * */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queenList = new int[n]; // queenList[row] = col of Queen at row;
        placeQueen(queenList, 0, n, res);
        return res;
    }

    private void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
        if (row == n) { // add the result
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < n; i++) { // iterate row
                String str = "";
                for (int col = 0; col < n; col++) { // iterate column
                    if (queenList[i] == col) {
                        str += "Q";
                    } else {
                        str += ".";
                    }
                }
                list.add(str);
            }
            res.add(list);
        }

        for (int col = 0; col < n; col++) {
            if (isValid(queenList, row, col)) { // if no conflict placing queen at [row, col]
                queenList[row] = col;
                placeQueen(queenList, row + 1, n, res);
            }
        }
    }

    private boolean isValid(int[] queenList, int row, int col) {
        for (int i = 0; i < row; i++) {
            int pos = queenList[i];
            if (pos == col) { // Queens can't be placed at the same column
                return false;
            }
            if (pos + row == col + i) { // Queens can't be placed at the same diagonal line
                return false;
            }
            if (pos - row == col - i) { // Queens can't be placed at the same diagonal line
                return false;
            }
        }
        return true;
    }
}
