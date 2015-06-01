/**
 * Created by GongLi on 1/6/15.
 */
public class ValidSudoku {

    public static boolean isValid(char[][] board, int row, int column) {
        if (row < 0 || row >= 9 || column < 0 || column >= 9) return false;

        char val = board[row][column];
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val && i != column) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][column] == val && i != row) return false;
        }

        // 3 * 3
        int startX = (row / 3) * 3;
        int startY = (column / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == val && (i != row || j != column)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.' && !isValid(board, i, j))
                    return false;

            }
        }

        return true;

    }


}
