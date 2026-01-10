class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][]dp=new int[n+1][m+1];
        for(int[]row:dp) Arrays.fill(row,-1);
        return sol(0,0,s1,s2,dp);
    }
    public int sol(int i,int j,String s1,String s2,int[][]dp){
        if(i==s1.length()){
           int sum = 0;
            for (int k = j; k < s2.length(); k++)
                sum += s2.charAt(k);
            return sum;
        }
        if(j==s2.length()){
           int sum = 0;
            for (int k = i; k < s1.length(); k++)
                sum += s1.charAt(k);
            return sum;
        }
        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j]=sol(i+1,j+1,s1,s2,dp);
        }
        else{
            int deleteS1=s1.charAt(i)+sol(i+1,j,s1,s2,dp);
            int deleteS2=s2.charAt(j)+sol(i,j+1,s1,s2,dp);
            dp[i][j]=Math.min(deleteS1,deleteS2);
        }
        return dp[i][j];

    }
}