public class d28_51_n_queens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queenList = new int[n]; // queenList[row] = col
        placeQueen(queenList, 0, n, res); // place Q on 0th row
        return res;
    }

    private void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
        if (row == n) {
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int col = 0; col < n; col++) {
                    if (queenList[i] == col) {
                        str += "Q";
                    }
                    else {
                        str += ".";
                    }
                }
                list.add(str);
            }
            res.add(list);
        }
        for (int col = 0; col < n; col++) { // iterate each column
            if (isValid(queenList, row, col)) { // if no conflict on placing Q in [row, col]
                queenList[row] = col;
                placeQueen(queenList, row + 1, n, res);
            }
        }
    }

    private boolean isValid(int[] queenList, int row, int col) {
        for (int i = 0; i < row; i++) {
            int pos = queenList[i];
            if (pos == col) { // newly added Q is on the same column
                return false;
            }
            if (pos + row - i == col) { // newly added Q is on the same diagonal line
                return false;
            }
            if (pos - row + i == col) { // newly added Q is on the same diagonal line
                return false;
            }
        }
        return true;
    }
}
