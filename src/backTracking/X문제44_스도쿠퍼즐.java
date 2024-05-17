package backTracking;

public class X문제44_스도쿠퍼즐 {
    private static final int N = 9;
    private static int[][] Board;

    private static int[][] solution(int[][] board) {
        Board = board;
        findSolution();
        return Board;
    }

    //현재 위치에 num 이 가능한지 검사
    private static boolean isValid(int num, int row, int col) {
        return !inRow(num, row) && !inCol(num, col) && !inBox(num, row, col);
    }

    // 해당 행에 num 이 있는지 확인
    private static boolean inRow(int num, int row) {
        for (int i = 0; i < N; i++) {
            if (Board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    // 해당 열에 num 이 있는지 확인
    private static boolean inCol(int num, int col) {
        for (int i = 0; i < N; i++) {
            if (Board[i][col] == num)
                return true;
        }
        return false;
    }

    private static boolean inBox(int num, int row, int col) {
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (Board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Block findEmptyPosition() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Board[i][j] == 0) {
                    return new Block(i, j);
                }
            }
        }
        return null;
    }

    private static boolean findSolution() {
        Block emptyPos = findEmptyPosition();
        if (emptyPos == null) {
            return true;
        }
        int row = emptyPos.i;
        int col = emptyPos.j;
        for (int num = 1; num <= 9; num++) {
            if (isValid(num, row, col)) {
                Board[row][col] = num;
                if (findSolution()) {
                    return true;
                }
                Board[row][col] = 0;
            }
        }
        return false;

    }

    private static class Block {
        int i, j;

        public Block(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
