class Solution {
    public boolean rotateString(String s, String goal) {
        String s2= s+s;
        if(s.length()!=goal.length()) return false;
        return s2.indexOf(goal)!=-1;
    }
}