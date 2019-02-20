package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SudokuSolver {
    //怎么找出一行中缺失的数
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    private boolean solve(char[][] board, int row) {
        for (int i = row; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (notContainNum(c, i, j, board)) {
                            board[i][j] = c;
                            if (solve(board, i))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean notContainNum(char num, int i, int j, char[][] board) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == num) return false;
            if (board[k][j] == num) return false;
            if (board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == num) return false;
        }
        return true;
    }


}
