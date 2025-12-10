class Solution {
    static int m=1000000007;
    public int countPermutations(int[] complexity) {
      long result=1;
        for(int i=1;i<complexity.length;i++){
            if(complexity[i]<=complexity[0]){
                return 0;
            }
            result=(result*i)%m;
        }
        return (int)result;
        
    }
}