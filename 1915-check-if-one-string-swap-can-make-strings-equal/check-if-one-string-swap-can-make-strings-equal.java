class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> l1=new ArrayList<>();
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                l1.add(i);
            }
        }
        if(l1.size()==2){
            int i=l1.get(0);
            int j=l1.get(1);
            if(s1.charAt(i)==s2.charAt(j) && s1.charAt(j)==s2.charAt(i)){
                return true;
            }
            return false;
        }
        if(l1.size()==0){
            return true;
        }
        return false;
    }
}