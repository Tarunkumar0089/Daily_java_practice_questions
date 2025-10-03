class Solution {
    public boolean exist(char[][] arr, String word) {
          for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == word.charAt(0)) {
                    boolean ans = sol(arr, i, j, word,0);
                    if (ans == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean sol(char[][] arr, int cr, int cc, String word,int idx) {
        if(idx==word.length()){
            return true;
        }
        if(cc<0||cr<0||cc>=arr[0].length||cr>=arr.length||word.charAt(idx)!=arr[cr][cc]){
            return false;
        }
        arr[cr][cc]='*';
        int[] r={-1,0,1,0};
        int[] c={0,-1,0,1};
        for(int i=0;i<r.length;i++){
            boolean ans=sol(arr,cr+r[i],cc+c[i],word,idx+1);
            if(ans==true){
                return true;
            }
        }
        arr[cr][cc]=word.charAt(idx);
       return false;
    }
}