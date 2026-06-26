class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    public static boolean solve(char[][] board,int row, int col){
        if(col==9){
            col=0;
            row++;
        }
        if(row==9){
            return true;
        }
        if(board[row][col] != '.'){
           return solve(board,row,col+1);
        }
        else{
           
            for(char val='1';val<='9';val++){
                if(isSafe(val,board,row,col)){
                    board[row][col]=val;
                   if(solve(board,row, col+1)) {
                    return true;
                   }
                    board[row][col]='.';
                }
            }
        }
        return false;
    }
    public static boolean isSafe(char val, char[][] board,int row, int col){
        for(int c=0;c<board[0].length;c++){
            if(board[row][c]==val){
                return false;
            }
        }
        //check column
        for(int r=0;r<board.length;r++){
            if(board[r][col]==val){
                return false;
            }
        }
        //check matrix;
        int r= row - row%3;
        int c= col - col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(board[i][j]==val){
                    return false;
                }
            }
        }
        return true;
        
    }

}