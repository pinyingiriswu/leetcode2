public class d18_240_search_a_2d_matrix_ii {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;

        int x = 0, y = col - 1;

        while (x < row && y >= 0) {
            if (target > matrix[x][y]) {
                x++;
            } else if (target < matrix[x][y]) {
                y--;
            } else {
                return true;
            }
        }

        return false;
    }
}
