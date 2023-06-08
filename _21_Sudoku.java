public class _21_Sudoku {
    public static void main(String[] args) {
        char[][] board = { { '9', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        System.out.println(isValidSudoku(board));
    }

    static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (safe(board, i, j, board[i][j])) {
                        board[i][j] = '.';

                        if (isValidSudoku(board)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean safe(char[][] board, int r, int c, char n) {
        board[r][c] = '.';

        for (int i = 0; i < 9; i++)
            if (board[i][c] == n)
                return false;

        for (int i = 0; i < 9; i++)
            if (board[r][i] == n)
                return false;

        int sqrt = (int) Math.sqrt(board.length);
        int rpos = r - r % sqrt;
        int cpos = c - c % sqrt;

        for (int i = rpos; i < rpos + sqrt; i++) {
            for (int j = cpos; j < cpos + sqrt; j++) {
                if (board[i][j] == n)
                    return false;
            }
        }

        return true;
    }
}
