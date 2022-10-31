// For N Queen there are N^2 boxes in board

import java.util.Arrays;
import java.util.Scanner;

public class _20_NQueenProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Queens : ");
        int N = sc.nextInt();
        int board[][] = new int[N][N];
        nQueen(board, 0, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        sc.close();
    }

    static boolean nQueen(int board[][], int row, int N) {

        if (row == N) {
            return true;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (nQueen(board, row + 1, N)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int b[][], int row, int col) {
        for (int i = row; i >= 0; i--) {
            if (b[i][col] == 1) {
                return false;
            }
        }

        // for upper-left diagonal
        int j = col;
        for (int i = row; i >= 0 && j >= 0; i--, j--) {
            if (b[i][j] == 1) {
                return false;
            }
        }

        // for upper-right diagonal
        j = col;
        for (int i = row; i >= 0 && j < b.length; i--, j++) {
            if (b[i][j] == 1)
                return false;
        }
        return true;
    }
}
