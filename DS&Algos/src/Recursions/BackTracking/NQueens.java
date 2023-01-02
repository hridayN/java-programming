package Recursions.BackTracking;

public class NQueens {
    public static void main(String[] args) {
        placeNQueens(4);
    }

    public static void placeNQueens(int n) {
        int[][] chessBoard = new int[n][n];
        placeQueens(chessBoard, n, 0);
    }

    public static void placeQueens(int[][] board, int n, int row) {
        if (row == n) {
            // As we,ve reached end, it's a valid configuration
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    //String end = (r == n -1 && c == n -1) ? "END" : " -> ";
                    if (board[r][c] == 1) System.out.print(String.format("(%d, %d) ", r, c));
                }
            }
            System.out.println();
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isBoardSafe(board, n, row, j)) {
                board[row][j] = 1;
                placeQueens(board, n, row + 1);
                board[row][j] = 0;
            }
        }
    }

    private static boolean isBoardSafe(int[][] board, int n, int row, int col) {
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) return false;
        }

        for (int i = row + 1; i < n; i++) {
            if (board[i][col] == 1) return false;
        }

        return true;
    }
}
