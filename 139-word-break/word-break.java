class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[][]dp=new Boolean[s.length()][s.length()];
        HashSet<String>set=new HashSet<>();
        for(String st:wordDict){
            set.add(st);
        }
        return sol(s,set,0,0,dp);
    }
    public boolean sol(String s,HashSet<String>set,int i,int j,Boolean[][]dp){
        if(i>=s.length()) return true;
        if(j>=s.length()) return false;

        if(dp[i][j]!=null) return dp[i][j];

        boolean np=sol(s,set,i,j+1,dp);
        boolean p=false;
        if(set.contains(s.substring(i,j+1))){
            p=sol(s,set,j+1,j+1,dp);
        }
        return dp[i][j]=p||np;
    }
}