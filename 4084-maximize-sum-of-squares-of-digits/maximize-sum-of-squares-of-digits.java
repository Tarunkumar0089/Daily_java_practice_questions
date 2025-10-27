class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum> 9*num){
            return "";
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<num;i++){
            sb.append(Math.min(9,sum));
            sum-= Math.min(9,sum);
        }
        return sb.toString();
    }
}