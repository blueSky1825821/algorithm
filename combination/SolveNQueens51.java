package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessboard[i], '.');
        }
        backtracking(chessboard, 0, n);
        return result;
    }

    List<List<String>> result = new ArrayList<>();

    //每次迭代都是深度
    public void backtracking(char[][] chessboard, int row, int n) {
        if (row >= n) {
            result.add(array2List(chessboard));
            return;
        }
        //列
        for (int col = 0; col < n; col++) {
            if (valid(row, col, chessboard, n)) {
                chessboard[row][col] = 'Q';// 放置皇后
                backtracking(chessboard, row + 1, n);//递归
                chessboard[row][col] = '.';//回溯撤销皇后
            }
        }
    }

    public boolean valid(int row, int col, char[][] chessboard, int n) {
        //列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        //45°
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        //135°
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
