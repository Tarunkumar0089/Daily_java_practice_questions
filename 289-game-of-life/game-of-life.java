class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int live = countLive(board, i, j);
                if (board[i][j] == 0) {
                    if (live == 3) {
                        board[i][j] = 2;
                    }
                }
                else {
                    if (live < 2)
                        board[i][j] = -1;
                    else if (live == 2 || live == 3)
                        board[i][j] = 1;
                    else if (live > 3)
                        board[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] >= 1) {
                    board[i][j] = 1;
                } else if (board[i][j] <= 0) {
                    board[i][j] = 0;
                }
            }
        }

    }

    public static int countLive(int[][] arr, int cr, int cc) {
        int live = 0;
        if (cr != 0 && (arr[cr - 1][cc] == 1 || arr[cr - 1][cc] == -1)) {
            live++;
        }
        if (cr != arr.length - 1 && (arr[cr + 1][cc] == 1 || arr[cr + 1][cc] == -1)) {
            live++;
        }
        if (cc != 0 && (arr[cr][cc - 1] == 1 || arr[cr][cc - 1] == -1)) {
            live++;
        }
        if (cc != arr[0].length - 1 && (arr[cr][cc + 1] == 1 || arr[cr][cc + 1] == -1)) {
            live++;
        }
        if (cr != 0 && cc != 0 && (arr[cr - 1][cc - 1] == 1 || arr[cr - 1][cc - 1] == -1)) {
            live++;
        }
        if (cr != arr.length - 1 && cc != 0 && (arr[cr + 1][cc - 1] == 1)) {
            live++;
        }
        if (cr != 0 && cc != arr[0].length - 1 && (arr[cr - 1][cc + 1] == 1 || arr[cr - 1][cc + 1] == -1)) {
            live++;
        }
        if (cr != arr.length - 1 && cc != arr[0].length - 1 && (arr[cr + 1][cc + 1] == 1 ||
                arr[cr + 1][cc + 1] == -1)) {
            live++;
        }
        return live;
    }
}