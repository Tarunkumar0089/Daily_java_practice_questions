class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        boolean[][] board = new boolean[n][n];  
        solveNQueens(board, n, 0, list); 
        return list;  
    }

    public void solveNQueens(boolean[][] board, int tq, int row, List<List<String>> list) {
        if (tq==0) {
            list.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;  
                solveNQueens(board, tq-1, row + 1, list);
                board[row][col] = false;  
            }
        }
    }

    public List<String> constructBoard(boolean[][] board) {
        List<String> ans = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean cell : row) {
                sb.append(cell ? 'Q' : '.');  
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public boolean isSafe(boolean[][] board, int row, int col) {
        int r = row, c = col;
        while (r >= 0) {
            if (board[r][col]) return false;
            r--;
        }
        r = row;
        c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) return false;
            r--;
            c--;
        }
        r = row;
        c = col;
        while (r >= 0 && c < board[0].length) {
            if (board[r][c]) return false;
            r--;
            c++;
        }

        return true;
    }
}
