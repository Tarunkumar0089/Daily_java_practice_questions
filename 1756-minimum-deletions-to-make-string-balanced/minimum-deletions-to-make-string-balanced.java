class Solution {
    public int minimumDeletions(String s) {
        int bCount=0;
        int delete=0;
        for(char c:s.toCharArray()){
            if(c=='b'){
               bCount++;
            }else{
                delete=Math.min(delete+1,bCount);
            }
        }
        return delete;
    }
}