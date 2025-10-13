class Solution {
    public boolean makeStringsEqual(String s, String t) {
        boolean one = s.contains("1");
        boolean two = t.contains("1");
        return one == two;
    }
}
