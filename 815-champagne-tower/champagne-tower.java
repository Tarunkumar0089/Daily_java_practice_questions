class Solution {
     double[][] t = new double[101][101];
    public double champagneTower(int poured, int query_row, int query_glass) {
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                t[i][j]=-1;
            }
        }
        return Math.min(1.0,sol(poured,query_row,query_glass));
    }
    public double sol(int p,int i,int j){
        if(i<0||j<0||i<j) return 0.0;
        if(i==0 && j==0) return p;
        if(t[i][j]!=-1) return t[i][j];
        double left_up=(sol(p,i-1,j-1)-1)/2.0;
        double right_up=(sol(p,i-1,j)-1)/2.0;

        if(left_up<0){
            left_up=0.0;
        }
        if(right_up<0){
            right_up=0.0;
        }
        return t[i][j]= left_up+right_up;
    }
}