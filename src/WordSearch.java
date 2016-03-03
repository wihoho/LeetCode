/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 3/3/2016.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i <board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if (dfs(board, 0, i, j, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int start, int x, int y, String word) {
        if (start == word.length()) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(start))
            return false;

        char temp = board[x][y];
        board[x][y] = '#';

        boolean result = dfs(board, start + 1, x - 1, y, word) || dfs(board, start + 1, x + 1, y, word) || dfs(board, start + 1, x, y - 1, word) || dfs(board, start + 1, x, y + 1, word);
        board[x][y] = temp;

        return result;
    }

    public static void main(String[] args) {

    }
}
