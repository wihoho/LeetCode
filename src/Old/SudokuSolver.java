package Old;

/**
 * Created by GongLi on 1/6/15.
 */
public class SudokuSolver {


    public static void main(String[] args) {


    }

    public static void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);

    }


    public static boolean solveSudoku(char[][] board, int row, int column) {

        if (row == 9) return true;

        int row1 = row, column1 = column + 1;
        if (column1 == 9) {
            row1++;
            column1 = 0;
        }

        // check value
        if (board[row][column] != '.') {
            if (!isValid(board, row, column)) return false;
            else return solveSudoku(board, row1, column1);
        }

        for (int i = 1; i <= 9; i++) {
            board[row][column] = (char) (i + '0');
            if (isValid(board, row, column) && solveSudoku(board, row1, column1)) return true;
        }

        board[row][column] = '.';

        return false;
    }


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

}
