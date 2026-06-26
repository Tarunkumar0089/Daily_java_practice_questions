class Solution {
    public void solveSudoku(char[][] arr) {
        sol(arr, 0, 0);
    }
    public static boolean sol(char arr[][], int cr, int cc){
        if(cr==9){
            return true;
        }
        if(cc==9){
           return sol(arr, cr+1, 0);
        }
        if(arr[cr][cc]!='.'){
            return sol(arr, cr, cc+1);
        }else{
            for(char i='1'; i<='9'; i++){
                if(isItPossible(arr, cr, cc, i)){
                    arr[cr][cc]=i;
                    if(sol(arr, cr,cc+1)){
                    return true;
                }
                }
                arr[cr][cc]='.';
            }
        }
        return false;
    }
     public static boolean isItPossible(char[][] board, int cr, int cc, char num) {
        for (int row = 0; row < 9; row++) {
            if (board[row][cc] == num) {
                return false;
            }
        }

        for (int col = 0; col < 9; col++) {
            if (board[cr][col] == num) {
                return false;
            }
        }

        int sr = (cr / 3) * 3;
        int sc = (cc / 3) * 3;

        for (int row = sr; row < sr + 3; row++) {
            for (int col = sc; col < sc + 3; col++) {
                if (board[row][col] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}